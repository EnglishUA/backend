package com.english.ua.shared.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String updateArticleImage(Long articleId, String articleImage, MultipartFile image);
}
