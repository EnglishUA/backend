package com.english.ua.atricle.repository;

import com.english.ua.atricle.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findAllByArticleId(Long articleId);
}
