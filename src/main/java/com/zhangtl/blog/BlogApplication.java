package com.zhangtl.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
/*开启service事务*/
@EnableTransactionManagement
@MapperScan("com.zhangtl.blog.**.mapper")
/*开启swagger*/
@EnableSwagger2Doc
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
