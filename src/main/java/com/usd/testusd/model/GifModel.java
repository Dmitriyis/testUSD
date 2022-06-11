package com.usd.testusd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GifModel {

    @JsonProperty(value = "data")
    private List<Content> contents;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Content {

        @JsonProperty(value = "images")
        private Image images;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Image {

        @JsonProperty(value = "original")
        private Original original;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Original {

        @JsonProperty(value = "url")
        private String url;
    }

}
