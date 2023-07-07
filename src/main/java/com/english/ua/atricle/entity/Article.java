package com.english.ua.atricle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@Builder(toBuilder = true)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Complexity complexity;

    @OneToMany
    private List<Page> pages;

    //todo: add createdAt and updatedAt
}
