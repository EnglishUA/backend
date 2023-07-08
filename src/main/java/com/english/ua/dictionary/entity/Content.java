package com.english.ua.dictionary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String content;

    @Column(length = 300)
    private String translation;

    @ManyToOne(
        optional = false,
        fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST)
    private Dictionary dictionary;
}
