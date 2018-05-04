package com.chuzihang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 在启动类上面加上@EnableScheduling即可开启定时
 */
@SpringBootApplication
@EnableScheduling
public class ChuzihangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuzihangApplication.class, args);
	}
}
