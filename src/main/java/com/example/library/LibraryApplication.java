package com.example.library;

import com.example.library.admin.Admin;
import com.example.library.admin.AdminService;
import com.example.library.book.*;
import com.example.library.category.Category;
import com.example.library.category.CategoryService;
import com.example.library.user.User;
import com.example.library.user.UserRequest;
import com.example.library.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AdminService adminService, CategoryService categoryService, UserService userService, BookService bookService) {
		return args -> {
			// Add Default Admin On Initialization
			Admin admin = new Admin("admin", "admin@ensa.ma", "password");
			adminService.saveAdmin(admin);
			// Add Default Categories On Initialization
			Category category = new Category(1, "Adventure stories", LocalDateTime.now());
			Category category2 = new Category(2, "Classics", LocalDateTime.now());
			Category category3 = new Category(3, "Crime", LocalDateTime.now());
			Category category4 = new Category(4, "Fantasy", LocalDateTime.now());
			categoryService.addCategory(category);
			categoryService.addCategory(category2);
			categoryService.addCategory(category3);
			categoryService.addCategory(category4);
			// Add Default Users On Initialization
			UserRequest user = new UserRequest("zakaria latif", "zakaria@ensa.ma", "EE0000");
			UserRequest user2 = new UserRequest("ilyasse bamoussa", "ilyasse@ensa.ma", "EE0001");
			UserRequest user3 = new UserRequest("mohamed laasri", "mohamed@ensa.ma", "EE0002");
			UserRequest user4 = new UserRequest("ikram jaa", "ikram@ensa.ma", "EE0003");
			UserRequest user5 = new UserRequest("nizar el hilali", "nizar@ensa.ma", "EE0004");
			userService.addUser(user);
			userService.addUser(user2);
			userService.addUser(user3);
			userService.addUser(user4);
			userService.addUser(user5);
			User u = new User("zakaria latif", "zakaria@ensa.ma", "EE0000");
			BookRequest bookRequest = new BookRequest("title", "ISBN 001", "Author 001", 33, "READY", "GOOD", "1", "1", "1", LocalDateTime.now(),LocalDateTime.now());
//			Book book = new Book( "title","ISBN 001", "Author", 33,Status.READY,State.GOOD,u,admin,category,LocalDateTime.now(), LocalDateTime.now());
//			Book book = new Book( Status.READY,State.GOOD,u,admin,LocalDateTime.now(), LocalDateTime.now());
//			Book book = new Book("title", "ISBN",  "author", 33 ,  category , Status.READY, State.GOOD, user,admin , LocalDateTime.now(), LocalDateTime.now());
//			bookService.addBook(bookRequest);
		};
	}
}
