package com.mashup.thing.youtuber;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private Long categoryId;

    public YouTuber(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
