package com.english.ua.dictionary.repository;

import com.english.ua.dictionary.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Content, Long> {
}
