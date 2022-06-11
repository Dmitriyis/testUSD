package com.usd.testusd.service;

import com.usd.testusd.exception.CurrencyException;
import com.usd.testusd.feign.ShowCourseUsd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class UsdService {

    private final ShowCourseUsd showCourseUsd;

    private final GifService gifService;

    public String showCourseUsd(String app_id, String currency) {

        BigDecimal actualCourseRub = Optional.ofNullable(showCourseUsd.getActualCourseUsd(app_id, currency)
                .getCurrencies().get(currency)).orElseThrow(() -> new CurrencyException("Invalid currency: " + currency));

        String dateChecksCourse = Stream.of(String.valueOf(LocalDate.now().minusDays(1)))
                .collect(Collectors.joining("-", "", ".json"));

        BigDecimal lastCourseRub = showCourseUsd.getActualCourseUsdByDate(dateChecksCourse, app_id, currency).getCurrencies()
                .get(currency);


        double resultDifference = actualCourseRub.subtract(lastCourseRub)
                .setScale(2, RoundingMode.DOWN).doubleValue();


        if (resultDifference > 0) {
            return gifService.getUrlGifByWord("rich");
        } else if (resultDifference < 0) {
            return gifService.getUrlGifByWord("broke");
        }

        return gifService.getUrlGifByWord("smail");

    }

}
