package com.usd.testusd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
