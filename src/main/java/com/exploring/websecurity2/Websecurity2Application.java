package com.exploring.websecurity2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan("model.*")   
public class Websecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(Websecurity2Application.class, args);
	}

}
