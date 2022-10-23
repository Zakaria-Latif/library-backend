package com.example.library.money;

import javax.persistence.*;

@Entity
public class Money {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(nullable = false)
    private int expenses;
    @Column(nullable = false)
    private int revenue;
}
