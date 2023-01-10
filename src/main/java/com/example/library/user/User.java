package com.example.library.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cin = "EE0000";
    @Column(nullable = false)
    private Boolean locked = false;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public User(String name, String email, String cin) {
        this.name = name;
        this.email = email;
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCin() {
        return cin;
    }
}
