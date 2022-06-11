package com.usd.testusd.feign;

import com.usd.testusd.model.GifModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "api.giphy.com/v1/gifs/search/")
public interface GetGif {

    @GetMapping()
    GifModel getGifs(@RequestParam(value = "api_key", defaultValue = "N6eHCQOsz1fn75vBG6tA9vzWCMsMshKv") String appKey,
                     @RequestParam(value = "q") String word);


}
