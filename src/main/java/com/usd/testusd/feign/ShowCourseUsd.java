package com.usd.testusd.feign;

import com.usd.testusd.model.UsdModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "usd", url = "https://openexchangerates.org/api/")
public interface ShowCourseUsd {

    @GetMapping(value = "latest.json")
    UsdModel getActualCourseUsd(@RequestParam("app_id") String app_id,
                                @RequestParam(value = "symbols") String currency);

    @GetMapping(value = "historical/{date}")
    UsdModel getActualCourseUsdByDate(@PathVariable("date") String date,
                                      @RequestParam("app_id") String app_id,
                                      @RequestParam(value = "symbols") String currency);
}
//?app_id=f149b4d3188d4cc58406422aa880564e