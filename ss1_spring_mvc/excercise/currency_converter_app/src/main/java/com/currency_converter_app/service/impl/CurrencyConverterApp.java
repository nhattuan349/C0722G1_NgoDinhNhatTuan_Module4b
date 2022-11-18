package com.currency_converter_app.service.impl;

import com.currency_converter_app.service.ICurrencyConverterApp;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterApp implements ICurrencyConverterApp {


    @Override
    public double converter(double usd) {
        return usd*22000;
    }
}
