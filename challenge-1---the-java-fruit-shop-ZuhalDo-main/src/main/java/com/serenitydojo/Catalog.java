package com.serenitydojo;

import java.util.*;

public class Catalog {

    private final Map<Fruit, Double> fruitToPrice = new HashMap<>();

    private final List<CatalogItem> availableFruits = new ArrayList<>();

    private  double total = 0.0;

    public void setPriceOf(Fruit fruit, double price) {
       // throw new RuntimeException("TODO, create a map to keep track of fruits and their prices");

        fruitToPrice.put(fruit,price);
    }

    public static Catalog withItems(CatalogItem... catalogItems) {
     //   throw new RuntimeException("TODO, create catalog and add items to the list of available fruits");

        Catalog catalog = new Catalog();
        catalog.availableFruits.addAll(Arrays.asList(catalogItems));
        return catalog;
    }


    public double getPriceOf(Fruit fruit) throws FruitUnavailableException {
        if(!fruitToPrice.containsKey(fruit)){
            throw new  FruitUnavailableException("Fruit not available: " + fruit.name()
            );
        }
        return fruitToPrice.get(fruit);
    }

    public List<CatalogItem> getAvailableFruits() {
        return availableFruits;
    }

    public double getTotal(){
        for(double price : fruitToPrice.values()){
            total += price;
        }
        return total;
    }

    public double buyFruitByKilos(Fruit fruit, double kilos) throws FruitUnavailableException {
        double priceOfFruit = getPriceOf(fruit);
        double total = priceOfFruit * kilos;

        if(kilos >= 5){
            total *= 0.9;
        }
        return total;
    }
}
