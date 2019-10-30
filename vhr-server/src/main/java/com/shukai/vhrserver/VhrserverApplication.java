package com.shukai.vhrserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.shukai.vhrserver.dao")
@SpringBootApplication
public class VhrserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrserverApplication.class, args);
	}

}
