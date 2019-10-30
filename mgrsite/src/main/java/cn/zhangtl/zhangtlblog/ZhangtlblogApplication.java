package cn.zhangtl.zhangtlblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.zhangtl.zhangtlblog.mapper")
public class ZhangtlblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhangtlblogApplication.class, args);
	}

}
