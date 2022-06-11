package com.usd.testusd.service;

import com.usd.testusd.feign.ShowCourseUsd;
import com.usd.testusd.model.UsdModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsdServiceTest {
    private final String CURRENCY = "RUB";
    private final UsdModel usdModelActual = UsdModel.builder()
            .baseCurrency(CURRENCY)
            .currencies(Map.of("RUB", BigDecimal.valueOf(65.00)))
            .build();
    private final UsdModel usdModelByDate = UsdModel.builder()
            .baseCurrency(CURRENCY)
            .currencies(Map.of("RUB", BigDecimal.valueOf(60.00)))
            .build();
    @MockBean
    private ShowCourseUsd showCourseUsd;
    @MockBean
    private GifService gifService;
    @Test
    void testShowCourseUsd() {
        when(showCourseUsd.getActualCourseUsd(any(String.class), any(String.class))).thenReturn(usdModelActual);
        when(showCourseUsd.getActualCourseUsdByDate(any(String.class), any(String.class), any(String.class))).thenReturn(usdModelByDate);
        when(gifService.getUrlGifByWord(any(String.class))).thenReturn("https://testUrl");


        UsdModel actualCourseUsd = showCourseUsd.getActualCourseUsd("test", "test");
        UsdModel actualCourseUsdByDate = showCourseUsd.getActualCourseUsdByDate("2022-06-11", "test", "test");

        BigDecimal priceCourse = actualCourseUsd.getCurrencies().get(CURRENCY);
        BigDecimal priceCourseByDate = actualCourseUsdByDate.getCurrencies().get(CURRENCY);



        double resultDifference = priceCourse.subtract(priceCourseByDate)
                .setScale(2, RoundingMode.DOWN).doubleValue();
        assertEquals(5, resultDifference);
    }

}