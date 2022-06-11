package com.usd.testusd.service;

import com.usd.testusd.feign.GetGif;
import com.usd.testusd.model.GifModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class GifServiceTest {
    private final String SEARCH_BY_WORD = "smail";
    private final String APP_KEY = "123";
    @MockBean
    private GetGif getGif;
    @Test
    void TestGetUrlGifByWord() {
        GifModel.Original original = new GifModel.Original();
        original.setUrl("https://testUrl");
        GifModel.Image image = new GifModel.Image();
        image.setOriginal(original);
        GifModel.Content content = new GifModel.Content();
        content.setImages(image);
        GifModel gifModel = new GifModel();
        gifModel.setContents(List.of(content));

        when(getGif.getGifs(any(String.class), any(String.class))).thenReturn(gifModel);


        GifModel gifs = getGif.getGifs(APP_KEY, SEARCH_BY_WORD);


        String url = gifs.getContents().get(0).getImages().getOriginal().getUrl();
        assertEquals("https://testUrl", url);

    }

}