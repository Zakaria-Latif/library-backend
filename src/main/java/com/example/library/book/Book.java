package com.example.library.book;

import com.example.library.admin.Admin;
import com.example.library.category.Category;
import com.example.library.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends Publication {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status = Status.READY;
    @Enumerated(EnumType.STRING)
    private State state = State.GOOD;
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name="userId", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false, name="assignedBy")
    private Admin admin;
    @Column(nullable = false)
    private LocalDateTime assignedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public Book(String title, String ISBN, String author, int price, LocalDateTime createdAt,Category category, Status status, State state, User user, Admin admin, LocalDateTime assignedAt, LocalDateTime createdAt1) {
        super(title, ISBN, author, price, createdAt, category);
        this.status = status;
        this.state = state;
        this.user = user;
        this.admin = admin;
        this.assignedAt = assignedAt;
        this.createdAt = createdAt1;
    }
}
