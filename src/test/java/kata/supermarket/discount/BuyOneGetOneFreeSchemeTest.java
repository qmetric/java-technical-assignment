// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.CountableProduct;
import kata.supermarket.Item;
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
        discountScheme = BuyOneGetOneFreeScheme.getInstance();
    }

    @Test
    public void testApplyForSingleItem() {
        CountableProduct countableProduct = new CountableProduct(BigDecimal.valueOf(2.22));
        countableProduct.setDiscountScheme(discountScheme);

        List<Item> itemList = Collections.singletonList(countableProduct.oneOf());

        Assert.assertEquals(BigDecimal.ZERO, discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsSingleItem() {
        CountableProduct product1 = new CountableProduct(BigDecimal.valueOf(2.22));
        product1.setDiscountScheme(discountScheme);

        WeighedProduct product2 = new WeighedProduct(BigDecimal.valueOf(2.22));
        product1.setDiscountScheme(discountScheme);

        List<Item> itemList = new ArrayList<>(Arrays.asList(product1.oneOf(), product2.weighing(BigDecimal.valueOf(1))));

        Assert.assertEquals(BigDecimal.ZERO, discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsMultipleEvenItems() {

        CountableProduct product1 = new CountableProduct(BigDecimal.valueOf(2.22));
        product1.setDiscountScheme(discountScheme);

        CountableProduct product2 = new CountableProduct(BigDecimal.valueOf(2.22));
        product2.setDiscountScheme(discountScheme);

        List<Item> itemList = new ArrayList<>(Arrays.asList(product1.oneOf(), product1.oneOf(), product2.oneOf(), product2.oneOf()));

        Assert.assertEquals(BigDecimal.valueOf(4.44), discountScheme.apply(itemList));
    }

    @Test
    public void testApplyForMultipleProductsMultipleOddItems() {

        CountableProduct product1 = new CountableProduct(BigDecimal.valueOf(2.22));
        product1.setDiscountScheme(discountScheme);

        CountableProduct product2 = new CountableProduct(BigDecimal.valueOf(2.22));
        product2.setDiscountScheme(discountScheme);

        List<Item> itemList =
                        new ArrayList<>(Arrays.asList(product1.oneOf(), product1.oneOf(), product2.oneOf(), product2.oneOf(), product2.oneOf()));

        Assert.assertEquals(BigDecimal.valueOf(4.44), discountScheme.apply(itemList));
    }
}
