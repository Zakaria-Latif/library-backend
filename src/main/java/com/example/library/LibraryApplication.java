package com.example.library;

import com.example.library.admin.Admin;
import com.example.library.admin.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AdminService adminService) {
		return args -> {
			BCryptPasswordEncoder encodedPassword = new BCryptPasswordEncoder();
			String password = encodedPassword.encode("password");
			// Add Default Admin On Initialization
			adminService.saveAdmin(new Admin("admin", "admin@ensa.ma", password));
		};
	}
}
