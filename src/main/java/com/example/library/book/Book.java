package com.example.library.book;

import com.example.library.category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Book {
    @Id
    @SequenceGenerator(
            name = "book",
            sequenceName = "book",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Long views = 0l;
    private int rate;
    @Column(nullable = false)
    private int nbrOfRates = 0;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String coverUrl;
    @Column(nullable = false)
    private Boolean approved = false;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(nullable = false, name="categoryId")
    private Category category;
}
