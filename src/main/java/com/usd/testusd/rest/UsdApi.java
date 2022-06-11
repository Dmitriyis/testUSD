package com.usd.testusd.rest;

import com.usd.testusd.service.UsdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usd")
public class UsdApi {

    private final UsdService usdService;

    @GetMapping()
    public String showGifOnBasedCurrencyUsd(@RequestParam("app_id") String app_id,
                                            @RequestParam(value = "symbols", defaultValue = "RUB") String currency,
                                            Model model) {

        String gifUrl = usdService.showCourseUsd(app_id, currency);
        model.addAttribute("message", gifUrl);

        return "gif";
    }

}
