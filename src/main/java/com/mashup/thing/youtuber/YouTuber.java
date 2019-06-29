package com.mashup.thing.youtuber;

import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "YouTuber")
public class YouTuber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long categoryId;

    public YouTuber(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
