package com.taxiService.taxi.models;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class PriceFactory {

    public static TaxiPrice getPrice(LocalTime timeNow){
        if(timeNow.getHour() < 20 && timeNow.getHour() > 9){
            return new TaxiPriceByDay();
        }
        else if(timeNow.getHour() < 9){
            return  new TaxiPriceByNight();
        }
        else return new FestivalTaxiPrice();
    }
}
