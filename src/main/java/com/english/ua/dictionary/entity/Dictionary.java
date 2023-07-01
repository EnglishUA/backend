package com.english.ua.repository.dictionary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
        mappedBy = "dictionary",
        fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE)
    private Set<Tag> tags;

    @OneToMany(
        mappedBy = "dictionary",
        fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE)
    private Set<Theme> themes;

    @OneToMany(
        mappedBy = "dictionary",
        fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE)
    private Set<Content> contents;

}
