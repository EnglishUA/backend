package com.english.ua.atricle.service;

import com.english.ua.atricle.entity.Content;

import java.util.List;

public interface ContentService {

    List<Content> findAll();

    List<Content> findAllByIds(List<String> contentIds);

    Content findById(String contentId);

    Content save(Content content);

    Content update(Content content);

    void deleteById(String contentId);
}
