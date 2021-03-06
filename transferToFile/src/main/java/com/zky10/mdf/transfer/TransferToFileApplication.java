package com.zky10.mdf.transfer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zky10.mdf.transfer.mapper")
public class TransferToFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferToFileApplication.class, args);
    }

}
