package com.mashup.thing.youtuber;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YouTuberRepository extends JpaRepository<YouTuber, Long> {
    Optional<YouTuber> findByNameAndCategoryId(String name, Long categoryId);
}
