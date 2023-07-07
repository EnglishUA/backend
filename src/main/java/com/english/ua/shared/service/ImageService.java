package com.english.ua.shared.service;

import com.english.ua.atricle.entity.Article;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String updateArticleImage(Article article, MultipartFile image);
}
