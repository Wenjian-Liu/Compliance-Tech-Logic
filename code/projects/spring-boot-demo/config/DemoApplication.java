package com.wenjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

	@SpringBootApplication
	@RestController
	public class DemoApplication {
		public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
		}

		@GetMapping("/hello")
		public String hello() {
			return "Hallo Wenjian-liu! C盤空間充足，Spring順利運行！";
		}
	}
