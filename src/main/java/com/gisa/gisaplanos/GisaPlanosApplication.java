package com.gisa.gisaplanos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class GisaPlanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GisaPlanosApplication.class, args);
	}

}
