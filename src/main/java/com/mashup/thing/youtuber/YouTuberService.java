package com.mashup.thing.youtuber;

import com.mashup.thing.category.CategoryType;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface YouTuberService {
    void saveYouTuber(List<WebElement> elements, CategoryType categoryType);
}
