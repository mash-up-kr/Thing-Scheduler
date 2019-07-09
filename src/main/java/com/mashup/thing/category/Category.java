package com.mashup.thing.category;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
