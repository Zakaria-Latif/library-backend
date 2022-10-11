package com.example.library.category;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Category {
    @Id
    @SequenceGenerator(
            name = "category",
            sequenceName = "category",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
