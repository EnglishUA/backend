package com.english.ua.article.service.impl;

import com.english.ua.article.entity.Content;
import com.english.ua.article.repository.ContentRepository;
import com.english.ua.article.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    //TODO:
    @Override
    public List<Content> findAllByIds(final List<String> contentIds) {
        return contentRepository.findAllById(contentIds);
    }

    @Override
    public Content findById(final String contentId) {
        return contentRepository.findById(contentId).orElseThrow();
    }

    @Override
    public Content save(final Content content) {
        final var newContent = contentRepository.save(content.toBuilder().id(UUID.randomUUID().toString()).build());
        if (content.getParent() != null) {
            final var parentContent = findById(content.getParent().getId());
            parentContent.getContents().add(newContent);
            contentRepository.save(parentContent);
        }

        return newContent;
    }

    @Override
    public Content update(final Content content) {
        return contentRepository.save(content);
    }

    @Override
    public void deleteById(final String contentId) {
        contentRepository.deleteById(contentId);
    }
}
