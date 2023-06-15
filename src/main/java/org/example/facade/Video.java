package org.example.facade;

import lombok.Getter;

@Getter
public class Video {
    private final String name;
    private final String codecType;

    public Video(String name) {
        this.name = name;
        this.codecType = name.substring(name.lastIndexOf(".") + 1);
    }
}
