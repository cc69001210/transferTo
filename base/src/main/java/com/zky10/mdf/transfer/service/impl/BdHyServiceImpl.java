package com.zky10.mdf.transfer.service.impl;

import com.zky10.mdf.transfer.config.MyObjectOutputStream;
import com.zky10.mdf.transfer.config.base.BaseTransferServiceImpl;
import com.zky10.mdf.transfer.mapper.BdHyMapper;
import com.zky10.mdf.transfer.pojo.entity.BdHy;
import com.zky10.mdf.transfer.service.BdHyService;
import com.zky10.mdf.transfer.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 婚姻信息表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
@Service
@Slf4j
public class BdHyServiceImpl extends BaseTransferServiceImpl<BdHyMapper, BdHy> implements BdHyService {

    private static final String TABLE_NAME = "BD_HY";

    @Autowired
    private BdHyMapper bdHyMapper;

    @Override
    public Long getMaxId() {
        return bdHyMapper.getMaxId();
    }

    @Override
    public boolean transferToFile() {
        Long lastNumber = FileUtil.getLastNumberByTableName(TABLE_NAME);
        log.info(" ====== 查询表名：{}，开始id为：{}", TABLE_NAME, lastNumber);

        // 查询最大id，进行分页，每页10000条
//        Long maxId = this.getMaxId();
        Long maxId = 100000L;
        MyObjectOutputStream outputStream = null;
        try {
            // 获取 写入到文件的输出流 ，参数是 输出的文件
            String filePathByTableName = FileUtil.getFileRecordPathByTableName(TABLE_NAME);
            log.info("【WARN】 ===== 表名：{}，从ID：{} 开始， 最大id：{}， 输出路径： {} ，start =======", TABLE_NAME, lastNumber, maxId, filePathByTableName);
            String dataFilePath = FileUtil.getFileDataPathByTableName(TABLE_NAME);
            outputStream = MyObjectOutputStream.newInstance(dataFilePath);
            Long maxSize = (maxId - lastNumber) / 10000;
            for (int i = 0; i <= maxSize; i++) {
                // sql是   rowNum > start and rowNum < end ,so  end = start + 10000 + 1
                List<BdHy> list = this.listNeedTransferData(lastNumber, lastNumber + 10000 + 1);
                // 将文件序列化到文件
                FileUtil.copyObject(outputStream, list);
                // 将新的数值写入到文件中
                FileUtil.resetLastNumByTableName(TABLE_NAME, lastNumber);
                log.info(" 【INFO】==== 表名：{} ，总页码：{} ，当前页码：{} ，开始id为：{}", TABLE_NAME, maxSize, i, lastNumber);
                // 下次的开始数据
                if (i != maxSize) {
                    lastNumber = lastNumber + 10000;
                }
            }
            log.info("【WARN】 ===== 表名：{}，从ID：{} 开始， 最大id：{}， 输出路径： {} ，end =======", TABLE_NAME, lastNumber, maxId, dataFilePath);
        } catch (Exception e) {
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
}
