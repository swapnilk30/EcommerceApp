package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EcommerceAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAppApplication.class, args);
		
		System.out.println("Application is running ...............................");
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("SecurePass123"));
		
	}

}
