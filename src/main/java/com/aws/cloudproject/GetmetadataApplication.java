package com.aws.cloudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class GetmetadataApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GetmetadataApplication.class, args);
		
		GetServerInfo info= new GetServerInfo();
		info.getInfo4Server(null, null);
	}
}
