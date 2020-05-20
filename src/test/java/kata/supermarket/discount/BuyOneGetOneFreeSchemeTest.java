// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.CountableProduct;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.ItemByWeight;
import kata.supermarket.WeighedProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuyOneGetOneFreeSchemeTest {

    private DiscountScheme discountScheme;

    @Before
    public void setUp() {
        discountScheme = new BuyOneGetOneFreeScheme();
    }

    @Test
    public void testApplyForSingleItem() {
        List<Item> itemList = Collections.singletonList(new ItemByUnit(new CountableProduct(BigDecimal.valueOf(2.22))));

        Assert.assertEquals(BigDecimal.ZERO, discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsSingleItem() {
        Item item1 = new ItemByUnit(new CountableProduct(BigDecimal.valueOf(2.22)));
        Item item2 = new ItemByWeight(new WeighedProduct(BigDecimal.valueOf(2.22)), BigDecimal.valueOf(2.22));
        List<Item> itemList = new ArrayList<>(Arrays.asList(item1, item2));

        Assert.assertEquals(BigDecimal.ZERO, discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsMultipleEvenItems() {

        CountableProduct product1 = new CountableProduct(BigDecimal.valueOf(2.22));
        CountableProduct product2 = new CountableProduct(BigDecimal.valueOf(2.22));
        Item item1 = new ItemByUnit(product1);
        Item item2 = new ItemByUnit(product1);
        Item item3 = new ItemByUnit(product2);
        Item item4 = new ItemByUnit(product2);
        List<Item> itemList = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));

        Assert.assertEquals(BigDecimal.valueOf(4.44), discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsMultipleOddItems() {

        CountableProduct product1 = new CountableProduct(BigDecimal.valueOf(2.22));
        CountableProduct product2 = new CountableProduct(BigDecimal.valueOf(2.22));
        Item item1 = new ItemByUnit(product1);
        Item item2 = new ItemByUnit(product1);
        Item item3 = new ItemByUnit(product2);
        Item item4 = new ItemByUnit(product2);
        Item item5 = new ItemByUnit(product2);

        List<Item> itemList = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5));

        Assert.assertEquals(BigDecimal.valueOf(4.44), discountScheme.apply(itemList));
    }
}
