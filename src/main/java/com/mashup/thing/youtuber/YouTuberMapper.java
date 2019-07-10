package com.mashup.thing.youtuber;

import com.mashup.thing.youtuber.domain.YouTuber;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class YouTuberMapper {
    public YouTuber toYouTuber(String name, String channelId, String description,
                               LocalDateTime publishedAt, String thumbnail,
                               Long subscriberCount, Long viewCount, Long categoryId) {

        return new YouTuber(name, channelId, description, publishedAt, thumbnail, viewCount, subscriberCount, categoryId);
    }
}
