package com.example.library.book;

import com.example.library.admin.Admin;
import com.example.library.category.Category;
import com.example.library.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBooks(){

        LocalDateTime date = LocalDateTime.now();

        Category category = Category.builder()
                .name("Self Help")
                .createdAt(date)
                .build();

        Admin admin = Admin.builder()
                .name("admin")
                .username("admin")
                .password("123456")
                .createdAt(date)
                .build();

        User Ahmed = User.builder()
                .name("Ahmed")
                .email("1@2.com")
                .cin("R1356")
                .locked(false)
                .updatedAt(date)
                .createdAt(date)
                .build();

        User Iman = User.builder()
                .name("Iman")
                .email("2@3.com")
                .cin("R1555")
                .locked(false)
                .updatedAt(date)
                .createdAt(date)
                .build();

        Book book1 = new Book(
                "The Subtle Art of not Giving a fcuk",
                "123456",
                "Mark Manson",
                15,
                date,
                category,
                Status.READY,
                State.GOOD,
                Ahmed,
                admin,
                date,
                date
                );

        Book book2 = new Book(
                "The Subtle Art of not Giving a fcuk",
                "123456",
                "Mark Manson",
                15,
                date,
                category,
                Status.RENTED,
                State.BAD,
                Ahmed,
                admin,
                date,
                date
        );

        bookRepository.saveAll(List.of(book1, book2));
    }
}