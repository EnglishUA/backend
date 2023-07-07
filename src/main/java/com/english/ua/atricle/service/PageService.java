package com.english.ua.atricle.service;

import com.english.ua.atricle.entity.Page;

import java.util.List;

public interface PageService {

    List<Page> findAll();

    List<Page> findAllByArticleId(Long articleId);

    Page findById(Long pageId);

    Page save(Page page);

    Page update(Page page);

    void deleteById(Long pageId);
}
