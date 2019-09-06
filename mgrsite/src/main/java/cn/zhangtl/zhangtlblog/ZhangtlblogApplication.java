package cn.zhangtl.zhangtlblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.zhangtl.zhangtlblog.mapper")
public class ZhangtlblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhangtlblogApplication.class, args);
	}

}
