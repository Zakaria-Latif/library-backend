package com.example.library.book;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookRequest {
    private final String title;
    private final String ISBN;
    private final String author;
    private final int price;
    private final String status;
    private final String state;
    private final String userId;
    private final String adminId;
    private final String categoryId;
    private final LocalDateTime assignedAt;
    private final LocalDateTime createdAt;
}
