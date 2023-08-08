package com.english.ua.article.repository;

import com.english.ua.article.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findAllByArticleId(Long articleId);
}
