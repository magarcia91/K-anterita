package com.ventasbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.ventasbackend" })
public class VentasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasBackendApplication.class, args);
	}

}
