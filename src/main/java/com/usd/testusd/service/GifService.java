package com.usd.testusd.service;

import com.usd.testusd.feign.GetGif;
import com.usd.testusd.model.GifModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GifService {

    private final GetGif getGif;

    public String getUrlGifByWord(String searchByWord) {

        GifModel gifsUrl = getGif.getGifs("N6eHCQOsz1fn75vBG6tA9vzWCMsMshKv", searchByWord);

        int size = gifsUrl.getContents().size();

        int randomGif = new Random().nextInt(size);

        return gifsUrl.getContents().get(randomGif).getImages().getOriginal().getUrl();
    }


}
