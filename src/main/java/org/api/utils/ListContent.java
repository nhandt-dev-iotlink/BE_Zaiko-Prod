package org.api.utils;

import java.util.List;

import lombok.Data;

@Data
public class ListContent<T> {

    private final List<T> content;

    public ListContent(List<T> content) {
        this.content = content;
    }

}
