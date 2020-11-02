package com.zky10.mdf.transfer.job;

import com.zky10.mdf.transfer.config.MyObjectInputStream;
import com.zky10.mdf.transfer.pojo.entity.BdHy;
import com.zky10.mdf.transfer.service.BdHyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 11:47
 * @Description:
 */
@Component
@Slf4j
public class DataTransferToDB {

    @Autowired
    private BdHyService bdHyService;

    @Autowired
    private ThreadPoolTaskExecutor transferExecutor;

    @PostConstruct
    public void init() {
        dataTransferToFile();
    }

    public void dataTransferToFile() {
        System.out.println("======================start " + System.currentTimeMillis());
        CountDownLatch countDownLatch = new CountDownLatch(5);

        // 开启一个线程
        transferExecutor.execute(() -> {
            log.info("========== 第一个线程。。。。。111111");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("第一个线程完成。。。。。。。");
                log.info("当前 countDown ..... {}", countDownLatch.getCount());
                countDownLatch.countDown();
            }

        });

        transferExecutor.execute(() -> {
            log.info("========== 第二个线程。。。。。22222");
            log.info("当前 countDown ..... {}", countDownLatch.getCount());
            log.info("第二个线程完成。。。。。。。");
            countDownLatch.countDown();
        });

        transferExecutor.execute(() -> {
            log.info("========== 第三个线程。。。。。33333");
            log.info("当前 countDown ..... {}", countDownLatch.getCount());
            log.info("第三个线程完成。。。。。。。");
            countDownLatch.countDown();
        });

        transferExecutor.execute(() -> {
            log.info("========== 第四个线程。。。。。44444");
            log.info("当前 countDown ..... {}", countDownLatch.getCount());
            log.info("第四个线程完成。。。。。。。");
            countDownLatch.countDown();
        });

        transferExecutor.execute(() -> {
            log.info("========== 第五个线程。。。。。55555");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                log.info("第五个线程完成。。。。。。。");
                log.info("当前 countDown ..... {}", countDownLatch.getCount());
                countDownLatch.countDown();
            }

        });
//        bdHyTransfer();

        try {
            log.info("五个线程都已经完成。");
            log.info("当前 countDown ..... {}", countDownLatch.getCount());
            countDownLatch.await();
        } catch (Exception e) {
            log.error("线程等待发生异常。。。。{}", e.getMessage(), e);
        }

        countDownLatch.getCount();
        log.info("当前 countDown ..... {}", countDownLatch.getCount());
        System.out.println("======================end " + System.currentTimeMillis());

        transferExecutor.shutdown();

    }

    /**
     * BD_HY 的数据转移 至数据库
     */
    public void bdHyTransfer() {
        File file = new File("F:\\abc");
        if (!file.exists()) {
            return;
        }
        MyObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new MyObjectInputStream(new FileInputStream(file));
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject instanceof List) {
                    List<BdHy> list = (List<BdHy>) readObject;
                    bdHyService.saveBatch(list);
                    log.info("插入数据成功");
                } else {
                    log.info("不是list");
                }
            }
        } catch (EOFException eofException) {
            log.error("数据已经读完了。。。。。");
            // 关闭资源
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            log.error("数据导入发生异常。。。");
        }
        // 数据处理完成
        file.deleteOnExit();
    }
}
