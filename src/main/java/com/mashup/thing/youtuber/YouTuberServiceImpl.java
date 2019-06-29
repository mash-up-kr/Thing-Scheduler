package com.mashup.thing.youtuber;

import com.mashup.thing.category.CategoryType;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class YouTuberServiceImpl implements YouTuberService {

    private final YouTuberRepository youTuberRepository;

    public YouTuberServiceImpl(YouTuberRepository youTuberRepository) {
        this.youTuberRepository = youTuberRepository;
    }

    @Transactional
    public void saveYouTuber(List<WebElement> topElements, List<WebElement> bottomElements, CategoryType categoryType) {
        topElements.forEach(topElement -> {
            save(topElement.getText(), categoryType.getPrimaryKey());
        });

        bottomElements.forEach(bottomElement -> {
            save(bottomElement.getText(), categoryType.getPrimaryKey());
        });
    }

    private void save(String name, Long categoryId) {
        YouTuber youTuber = new YouTuber(name, categoryId);
        youTuberRepository.save(youTuber);
    }

}