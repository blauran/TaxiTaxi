package com.taxiService.taxi.models;

public class TaxiPriceByNight implements TaxiPrice {

    @Override
    public float price() {
        return 2.5f;
    }
}
