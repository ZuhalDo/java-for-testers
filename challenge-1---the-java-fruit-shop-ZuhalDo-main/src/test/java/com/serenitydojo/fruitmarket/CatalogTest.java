package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.CatalogItem;

import com.serenitydojo.FruitUnavailableException;
import org.junit.Test;


import java.util.Comparator;
import java.util.List;

import static com.serenitydojo.Fruit.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;


public class CatalogTest {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() throws FruitUnavailableException {
// TODO: Uncomment this code and make it work
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple, 4.00);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    @Test
    public void shouldListAvailableFruitsAlphabetically() {
// TODO: Uncomment this code and make it work
        Catalog catalog = Catalog.withItems(
          new CatalogItem(Pear, 1),
          new CatalogItem(Apple, 1),
         new CatalogItem(Banana, 1)
        );

        List<CatalogItem> availableFruits = catalog.getAvailableFruits();
        availableFruits.sort(Comparator.comparing(CatalogItem::getFruit));
         assertThat(availableFruits.get(0).getFruit()).isEqualTo(Apple);
        assertThat(availableFruits.get(1).getFruit()).isEqualTo(Banana);
        assertThat(availableFruits.get(2).getFruit()).isEqualTo(Pear);
    }

    @Test
    public void shouldThrowFruitUnavailableException(){
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple,9);

        try{
            catalog.getPriceOf(Orange);
            //fail("Expected a Exception to be thrown");
        }catch (FruitUnavailableException e) {
            System.out.println(e.getMessage());
            assertEquals("Fruit not available: Orange", e.getMessage());
        }

    }

    @Test
    public void addItemsToShoppingCart() throws FruitUnavailableException {
        Catalog cart = new Catalog();

        cart.setPriceOf(Apple,5.0);
        cart.setPriceOf(Orange,2.0);
        cart.setPriceOf(Pear,1.0);
        cart.setPriceOf(Banana,6.0);

       double expected = cart.getPriceOf(Apple) +
               cart.getPriceOf(Orange) +
               cart.getPriceOf(Pear) +
               cart.getPriceOf(Banana);

        assertThat(cart.getTotal()).isEqualTo(expected);
    }

    @Test
    public void whenBuy5KilosOrMoreGetDiscount() throws FruitUnavailableException {

        Catalog catalog =new Catalog();
        catalog.setPriceOf(Orange, 5.0);

        double forFive= catalog.buyFruitByKilos(Orange,5);
        double forThree= catalog.buyFruitByKilos(Orange ,3);

        double expectedFive = 5.0 * 5 * 0.9;
        assertThat(forFive).isEqualTo(expectedFive);

        double expectedThree = 5.0 *3;
        assertThat(forThree).isEqualTo(expectedThree);

    }
}
