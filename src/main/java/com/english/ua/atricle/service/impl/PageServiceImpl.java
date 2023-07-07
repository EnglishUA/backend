package com.english.ua.atricle.service.impl;

import com.english.ua.atricle.entity.Page;
import com.english.ua.atricle.repository.PageRepository;
import com.english.ua.atricle.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public List<Page> findAllByArticleId(final Long articleId) {
        return pageRepository.findAllByArticleId(articleId);
    }

    @Override
    public Page findById(final Long pageId) {
        return pageRepository.findById(pageId).orElseThrow();
    }

    @Override
    public Page save(final Page page) {
        return pageRepository.save(page);
    }

    @Override
    public Page update(final Page page) {
        return pageRepository.save(page);
    }

    @Override
    public void deleteById(final Long pageId) {
        pageRepository.deleteById(pageId);
    }
}
