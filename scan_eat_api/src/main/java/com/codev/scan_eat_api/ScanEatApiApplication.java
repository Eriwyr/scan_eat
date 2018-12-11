package com.codev.scan_eat_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ScanEatApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScanEatApiApplication.class, args);
	}
}
