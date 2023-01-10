package com.example.library.book;

import com.example.library.admin.Admin;
import com.example.library.category.Category;
import com.example.library.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Book  extends  Publication{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status = Status.READY;
    @Enumerated(EnumType.STRING)
    private State state = State.GOOD;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name="userId")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false, name="assignedBy")
    private Admin admin;
    @Column(nullable = false)
    private LocalDateTime assignedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public Book() {
    }

    public Book(String title, String ISBN, String author, int price, Category category, Status status, State state, User user, Admin admin, LocalDateTime assignedAt, LocalDateTime createdAt) {
        super(title, ISBN, author, price, category);
        this.status = status;
        this.state = state;
        this.user = user;
        this.admin = admin;
        this.assignedAt = assignedAt;
        this.createdAt = createdAt;
    }
}
