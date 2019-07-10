package com.mashup.thing.youtuber;

import com.mashup.thing.category.CategoryType;
import com.mashup.thing.youtuber.domain.YouTuber;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class YouTuberService {

    private final YouTuberRepository youTuberRepository;

    private static String NAME_NULL = "NULL";

    public YouTuberService(YouTuberRepository youTuberRepository) {
        this.youTuberRepository = youTuberRepository;
    }

    public void saveYouTubers(List<YouTuber> youTubers) {
        youTubers.forEach(this::save);
    }

    private void save(YouTuber youTuber) {
        if(isYouTuber(youTuber)) {
            return;
        }
        if(!youTuber.isNameNull(NAME_NULL)) {
            youTuberRepository.save(youTuber);
        }
    }

    private Boolean isYouTuber(YouTuber youTuber) {
        return youTuberRepository.findByNameAndCategoryId(youTuber.getName(), youTuber.getCategoryId()).isPresent();
    }



}