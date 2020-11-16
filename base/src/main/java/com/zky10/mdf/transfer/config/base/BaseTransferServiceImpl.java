package com.zky10.mdf.transfer.config.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zky10.mdf.transfer.config.MyObjectOutputStream;
import com.zky10.mdf.transfer.config.PropertiesConfig;
import com.zky10.mdf.transfer.util.DateTransferUtil;
import com.zky10.mdf.transfer.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-11-02 10:30
 * @Description:
 */
@Slf4j
public abstract class BaseTransferServiceImpl<M extends BaseMapper<T>, T extends Model> extends ServiceImpl<M, T> implements BaseTransferService<T> {


    @Override
    public boolean transferToFile(String tableName) {
        log.warn("开始进行表名====={}========的采集", tableName);
        log.warn("开始进行表名====={}========的采集", tableName);
        log.warn("开始进行表名====={}========的采集", tableName);
        // 查询最大id，进行分页，每页 pageSize 条
        Long maxId = this.getMaxId();
//        Long maxId = 1000000000L;
        MyObjectOutputStream outputStream = null;
        try {
            // 获取 写入到文件的输出流 ，参数是 输出的文件
            String fileRecordPath = DateTransferUtil.getFileRecordPathByTableName(tableName);
            String fileDataPath = DateTransferUtil.getFileDataPathByTableName(tableName);
            String fileDataBackPath = DateTransferUtil.getFileDataBackPathByTableName(tableName);
            // 创建 记录文件
            FileUtil.createFile(fileRecordPath);
            // 创建（移动） 数据文件
            FileUtil.createAndMoveFile(fileDataPath, fileDataBackPath);
            // 获取上次读取到的 记录数
            Long lastNumber = DateTransferUtil.getLastNumberByTableName(tableName);
            // 获取分页大小
            Integer pageSize = Integer.parseInt(Optional.ofNullable(PropertiesConfig.getProperty("page.pageSize")).orElse("1000"));
            log.info(" ====== 查询表名：{}，开始id为：{}", tableName, lastNumber);
            outputStream = MyObjectOutputStream.newInstance(fileDataPath);

            // 数据查询
            while (true) {
                long end = lastNumber + pageSize + 1;
                // sql是   rowNum > start and rowNum < end ,so  end = start + 10000 + 1
                List<T> list = this.listNeedTransferData(lastNumber, end);
                if (CollectionUtils.isEmpty(list)) {
                    log.debug("本次查询范围：{}，{}，查询无数据",lastNumber,end);
                } else {
                    // 将文件序列化到文件
                    DateTransferUtil.copyObject(outputStream, list);
                    // 将新的数值写入到文件中
                    DateTransferUtil.resetLastNumByTableName(tableName, lastNumber);
                    log.info(" 【INFO】==== 表名：{} ，开始id为：{}", tableName, lastNumber);
                }

                // 文件结束判断
                if (end > maxId) {
                    log.warn("查询表名：【{}】已经采集完成", tableName);
                    log.warn("查询表名：【{}】已经采集完成", tableName);
                    break;
                } else {
                    lastNumber += pageSize;
                }
            }
            log.info("【WARN】 ===== 表名：{}，从ID：{} 开始， 最大id：{}， 输出路径： {} ，end =======", tableName, lastNumber, maxId, fileDataPath);
        } catch (
                Exception e) {
            log.error("写入文件失败===={}", e.getMessage(), e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;

    }

    @Override
    public boolean transferToDB() {
        return false;
    }

    @Override
    public Long getNeedTransCount(Long lastNumber) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("ID", lastNumber);
        return (long) this.count(queryWrapper);
    }

    @Override
    public abstract Long getMaxId();

    @Override
    public List<T> listNeedTransferData(Long start, long end) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("ID", start);
        queryWrapper.lt("ID", end);
        return this.list(queryWrapper);
    }


}
