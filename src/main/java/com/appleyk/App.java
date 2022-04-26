package com.appleyk;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


//@SpringBootApplication：标注这个类是一个springboot启应用：启动类下的所有资源
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration// @ComponentScan
public class App extends SpringBootServletInitializer {

	// 将springboot应用启动
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

}
