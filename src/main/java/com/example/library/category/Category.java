package com.example.library.category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Category(int id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Category() {

    }
}
