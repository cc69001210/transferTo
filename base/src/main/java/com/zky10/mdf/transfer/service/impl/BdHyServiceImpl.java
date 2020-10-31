package com.zky10.mdf.transfer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.base.common.service.impl.BaseServiceImpl;
import com.zky10.mdf.transfer.config.MyObjectOutputStream;
import com.zky10.mdf.transfer.mapper.BdHyMapper;
import com.zky10.mdf.transfer.pojo.entity.BdHy;
import com.zky10.mdf.transfer.service.BdHyService;
import com.zky10.mdf.transfer.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class BdHyServiceImpl extends BaseServiceImpl<BdHyMapper, BdHy> implements BdHyService {

    @Autowired
    private BdHyMapper bdHyMapper;

    @Override
    public Long getNeedTransCount(Long lastNumber) {
        QueryWrapper<BdHy> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().gt(BdHy::getId, lastNumber);
        return (long) this.count(queryWrapper);
    }

    @Override
    public Long getMaxId() {
        return bdHyMapper.getMaxId();
    }

    @Override
    public List<BdHy> listByStartAndEnd(Long start, long end) {
        QueryWrapper<BdHy> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().gt(BdHy::getId, start);
        queryWrapper.lambda().lt(BdHy::getId, end);
        return this.list(queryWrapper);
    }


    @Override
    public boolean transferToFile() {
        Long lastNumber = FileUtil.getLastNumber("files/HY_BD.last");
        log.info(" ====== 查询表名：{}，开始id为：{}", "HY_BD", lastNumber);
        Long startId = this.getNeedTransCount(lastNumber);
        log.info(" ====== 查询表名：{}，总计要查询count为 ：{}", "HY_BD", startId);

//        Long maxId = bdHyService.getMaxId();
        Long maxId = 100000L;
        // 循环 查询
        try {
            MyObjectOutputStream outputStream = MyObjectOutputStream.newInstance("F://abc");
            Long maxSize = (maxId - lastNumber) / 10000;

            for (int i = 0; i <= maxSize; i++) {
                List<BdHy> list = this.listByStartAndEnd(lastNumber, lastNumber + 10000);
                // 将文件序列化到文件
                FileUtil.copyObject(outputStream, list);
                // 将新的数值写入到文件中
                lastNumber = lastNumber + 10000;
                FileUtil.resetLastNum("files/HY_BD.last", lastNumber);
                log.info(" 总页码：{} ，当前页码：{} ====== 查询表名：{}，开始id为：{}", maxSize, i, "HY_BD", lastNumber);
            }
        } catch (Exception e) {
            log.error("写入文件失败===={}", e.getMessage(), e);
        }
        return false;
    }
}
