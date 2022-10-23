package com.example.library.book;

import com.example.library.category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String ISBN;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name="categoryId")
    private Category category;

    public Publication(){

    }

    public Publication(String title, String ISBN, String author, int price,  Category category) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.category = category;
    }
}
