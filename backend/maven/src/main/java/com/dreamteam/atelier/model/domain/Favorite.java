package com.dreamteam.atelier.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Базовый тип описывающий сущность - избранные пользователя
 */
@Document(collection = "favorites")
@TypeAlias(value = "favorite")
@Data
@EqualsAndHashCode
@RequiredArgsConstructor
public class Favorite {

    @Id
    private String id;
    @Indexed(unique = true)
    private UUID uuid;
    @DBRef
    private List<Item> items;

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void removeItem(Item item) {
        if (items != null) {
            items.remove(item);
        }
    }

}
