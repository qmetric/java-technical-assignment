package kata.supermarket.pricecaluator;

import kata.supermarket.Basket;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalcuatorTest {

    private Basket testBasket;

    private final static BigDecimal PRODUCT_PRICE = BigDecimal.valueOf(1.55);

    private final static BigDecimal PRODUCT_PRICE_ONE = BigDecimal.valueOf(2.55);

    private final static BigDecimal PRODUCT_PRICE_THREE = BigDecimal.valueOf(3.55);

    @Test
    void shouldReturnTotalPrice_givenValidDiscountApplied() {
        testBasket = new Basket();

        testBasket.add(createItem(PRODUCT_PRICE));
        testBasket.add(createItem(PRODUCT_PRICE_ONE));
        testBasket.add(createItem(PRODUCT_PRICE));

        assertThat(testBasket.caluateTotalToPay()).isEqualTo(PRODUCT_PRICE.add(PRODUCT_PRICE_ONE));
    }

    @Test
    void shouldReturnTotalPrice_givenNoValidDiscountApplied(){
        testBasket = new Basket();

        testBasket.add(createItem(PRODUCT_PRICE));
        testBasket.add(createItem(PRODUCT_PRICE_ONE));
        testBasket.add(createItem(PRODUCT_PRICE_THREE));

        assertThat(testBasket.caluateTotalToPay()).isEqualTo(PRODUCT_PRICE.add(PRODUCT_PRICE_ONE).add(PRODUCT_PRICE_THREE));
    }

    @Test
    void shouldReturnTotalSubPrice_givenAllItems(){
        testBasket = new Basket();

        testBasket.add(createItem(PRODUCT_PRICE));
        testBasket.add(createItem(PRODUCT_PRICE_ONE));
        testBasket.add(createItem(PRODUCT_PRICE_ONE));

        assertThat(testBasket.caluateTotalToPay()).isEqualTo(PRODUCT_PRICE.add(PRODUCT_PRICE_ONE).add(PRODUCT_PRICE_ONE));
    }

    private Item createItem(BigDecimal productPrice){
        return new ItemByUnit(createProduct(productPrice));
    }

    private Product createProduct(BigDecimal productPrice){
        return new Product(productPrice);
    }
}