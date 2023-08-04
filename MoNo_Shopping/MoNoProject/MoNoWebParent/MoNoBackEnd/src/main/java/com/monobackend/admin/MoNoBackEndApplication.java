package com.monobackend.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.mono.common" })
public class MoNoBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoNoBackEndApplication.class, args);
	}

}
