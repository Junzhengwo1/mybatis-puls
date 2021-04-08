package com.kou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dell
 */
@SpringBootApplication
//扫描我们的Mapper文件夹
@MapperScan("com.kou.mapper")
public class MybatisPulsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPulsApplication.class, args);
    }

}
