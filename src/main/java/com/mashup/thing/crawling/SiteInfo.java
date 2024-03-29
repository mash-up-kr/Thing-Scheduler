package com.mashup.thing.crawling;

import com.mashup.thing.category.CategoryType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SiteInfo {
    private List<String> urls;
    private CategoryType categoryType;

    public SiteInfo() {
        urls = new ArrayList<>();
    }

}
