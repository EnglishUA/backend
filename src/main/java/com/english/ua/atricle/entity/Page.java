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
@Table(name = "pages")
@Builder(toBuilder = true)
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Column(nullable = false)
    private String title;

    @OrderColumn
    @Column(name = "content_id", nullable = false)
    @ElementCollection
    @CollectionTable(
            name = "page_content",
            joinColumns = @JoinColumn(name = "page_id", referencedColumnName = "id", nullable = false)
    )
    private List<Long> content;

    //todo: add createdAt and updatedAt
}
