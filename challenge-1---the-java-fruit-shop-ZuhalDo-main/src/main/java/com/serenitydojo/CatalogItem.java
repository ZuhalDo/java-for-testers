package com.serenitydojo;

public class CatalogItem {

    private final Fruit fruit;
    private double price;

    public CatalogItem(Fruit fruit, double price) {

        this.fruit = fruit;
        this.price = price;

    }

    public Fruit getFruit(){
        return fruit;
    }

    public double getPrice(){
        return price;
    }
}
