package com.mashup.thing.youtuber;

import com.mashup.thing.category.CategoryType;
import org.openqa.selenium.WebElement;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class YouTuberServiceImpl implements YouTuberService {

    private final YouTuberRepository youTuberRepository;

    private static String NAME_NULL = "NULL";

    public YouTuberServiceImpl(YouTuberRepository youTuberRepository) {
        this.youTuberRepository = youTuberRepository;
    }

    public void saveYouTuber(List<WebElement> elements, CategoryType categoryType) {
        elements.forEach(topElement -> {
            save(topElement.getText(), categoryType.getPrimaryKey());
        });
    }

    private void save(String name, Long categoryId) {
        if(isYouTuber(name, categoryId)) {
            return;
        }

        if(!isNameNull(name)) {
            YouTuber youTuber = new YouTuber(name, categoryId);
            youTuberRepository.save(youTuber);
        }
    }

    private Boolean isYouTuber(String name, Long categoryId) {
        return youTuberRepository.findByNameAndCategoryId(name, categoryId).isPresent();
    }

    private Boolean isNameNull(String name) {
        return name.equalsIgnoreCase(NAME_NULL);
    }

}