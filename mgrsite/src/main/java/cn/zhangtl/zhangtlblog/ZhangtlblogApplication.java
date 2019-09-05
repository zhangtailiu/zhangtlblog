package cn.zhangtl.zhangtlblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan
public class ZhangtlblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhangtlblogApplication.class, args);
	}

}
