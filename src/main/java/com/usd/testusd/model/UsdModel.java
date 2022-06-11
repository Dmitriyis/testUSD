package com.usd.testusd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
public class UsdModel {

    @JsonProperty(value = "base")
    private String baseCurrency;

    @JsonProperty(value = "rates")
    private Map<String, BigDecimal> currencies;
}
