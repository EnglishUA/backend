package com.english.ua.dictionary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Getter
@Setter
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(name = "hierarchy_level")
    private Short hierarchyLevel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_theme")
    private Theme parentTheme;

    @OneToMany(mappedBy = "parentTheme", cascade = CascadeType.PERSIST)
    private Set<Theme> childrenTheme;

    @ManyToOne(
        optional = false,
        fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST)
    private Dictionary dictionary;
}
