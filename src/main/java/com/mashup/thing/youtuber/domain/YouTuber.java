package com.mashup.thing.youtuber.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@Table
public class YouTuber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String channelId;
    @Lob
    @Column(name="description", length=512)
    private String description;
    private LocalDateTime publishedAt;
    private String thumbnail;
    private Long subscriberCount;
    private Long viewCount;
    private Long categoryId;


    public YouTuber(String name, String channelId, String description,
                    LocalDateTime publishedAt, String thumbnail, Long viewCount,
                    Long subscriberCount, Long categoryId) {
        this.name = name;
        this.channelId = channelId;
        this.description = description;
        this.publishedAt = publishedAt;
        this.thumbnail = thumbnail;
        this.viewCount = viewCount;
        this.subscriberCount = subscriberCount;
        this.categoryId = categoryId;
    }

    public Boolean isNameNull(String spec) {
        return this.name.equalsIgnoreCase(spec);
    }
}
