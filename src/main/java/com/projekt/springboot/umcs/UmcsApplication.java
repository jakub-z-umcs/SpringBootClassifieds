package com.projekt.springboot.umcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UmcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmcsApplication.class, args);
	}

	@GetMapping
	public String ads() {
		return "Simple ad";
	}

}
