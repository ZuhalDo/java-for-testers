package com.serenitydojo;

import org.junit.Test;

public class WhenWorkingWithFloatingPointNumber {

    @Test
    public void convertCelsiusToFahrenheit(){

        float fahrenheit;
        float celsius;

        celsius=32;
        fahrenheit=((celsius*9)/5)+32;
        System.out.println(fahrenheit);
    }

    @Test
    public void convertKiloToPound(){

        double kilo;
        double pound;
        kilo= 63;
        pound=kilo*2.2;

        System.out.println(pound);
    }
}
