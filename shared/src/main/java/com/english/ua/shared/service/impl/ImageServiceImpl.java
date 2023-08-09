package com.english.ua.shared.service.impl;

import com.english.ua.shared.service.ImageService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private String articleBaseFilepath;
    private final Environment env;

    @PostConstruct
    void initialize() {
        try {
            if (Arrays.stream(env.getActiveProfiles()).anyMatch(profile -> profile.equals("localDocker") || profile.equals("prod"))) {
                articleBaseFilepath = "/static/images/articles";
            } else {
                final String baseFilepath = ResourceUtils.getFile("classpath:").getPath();
                articleBaseFilepath = baseFilepath + "/static/images/articles";
            }
            File directory = new File(articleBaseFilepath);
            if (!directory.exists()) {
                Files.createDirectories(directory.toPath());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String updateArticleImage(final Long articleId, final String articleImage, final MultipartFile image) {
        try {
            String imageFilepath;
            File imageFile;
            if (articleImage != null) {
                imageFilepath = String.format("%s/%d%s", articleBaseFilepath, articleId, articleImage);
                imageFile = new File(imageFilepath);
                if (imageFile.exists()) {
                    imageFile.delete();
                }
            }
            if (image == null) {
                return null;
            }

            imageFilepath = String.format("%s/%d%s", articleBaseFilepath, articleId, image.getOriginalFilename());
            imageFile = new File(imageFilepath);
            image.transferTo(imageFile);
            return imageFile.getName();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("Error during update article avatar");
        }
    }
}
