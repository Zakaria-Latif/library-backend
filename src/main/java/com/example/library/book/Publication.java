package com.example.library.book;

import com.example.library.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name="categoryId")
    private Category category;

    public Publication(String title, String ISBN, String author, int price, LocalDateTime createdAt, Category category) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.createdAt = createdAt;
        this.category = category;
    }
}
