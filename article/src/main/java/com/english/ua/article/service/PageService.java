package com.english.ua.article.service;

import com.english.ua.article.entity.Page;

import java.util.List;

public interface PageService {

    List<Page> findAll();

    List<Page> findAllByArticleId(Long articleId);

    Page findById(Long pageId);

    Page save(Page page);

    Page update(Page page);

    void deleteById(Long pageId);
}
