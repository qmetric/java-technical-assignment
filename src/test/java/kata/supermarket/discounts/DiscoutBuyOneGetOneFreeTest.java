package kata.supermarket.discounts;

import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DiscoutBuyOneGetOneFreeTest {

    private DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree = new DiscoutBuyOneGetOneFreeImpl();

    private final static BigDecimal PRODUCT_PRICE_BOGOF = BigDecimal.valueOf(1.55);
    private final static BigDecimal PRODUCT_PRICE_NO_BOGOF = BigDecimal.valueOf(2.00);

    @Test
    void shouldReturnTotalDiscount_givenValidTiemsBOGOF() {

        List<Item> testList =  new ArrayList();
        testList.add(createItem(PRODUCT_PRICE_BOGOF));
        testList.add(createItem(PRODUCT_PRICE_BOGOF));

        BigDecimal result = discoutBuyOneGetOneFree.discount_BuyOneGetOneFree(testList);

        assertThat(result).isEqualTo(PRODUCT_PRICE_BOGOF);
    }

    @Test
    void shouldReturnTotalDiscountZero_givenInvalidBOGOF(){

        List<Item> testList =  new ArrayList();
        testList.add(createItem(PRODUCT_PRICE_BOGOF));
        testList.add(createItem(PRODUCT_PRICE_NO_BOGOF));

        BigDecimal result = discoutBuyOneGetOneFree.discount_BuyOneGetOneFree(testList);

        assertThat(result).isEqualTo(PRODUCT_PRICE_BOGOF.multiply(BigDecimal.valueOf(2)));

    }

    @Test
    void shouldReturnTotalDiscount_givenValidItemsBOGOFLarger(){

        List<Item> testList =  new ArrayList();
        testList.add(createItem(PRODUCT_PRICE_BOGOF));
        testList.add(createItem(PRODUCT_PRICE_NO_BOGOF));
        testList.add(createItem(PRODUCT_PRICE_BOGOF));

        BigDecimal result = discoutBuyOneGetOneFree.discount_BuyOneGetOneFree(testList);

        assertThat(result).isEqualTo(PRODUCT_PRICE_BOGOF.add(PRODUCT_PRICE_NO_BOGOF));

    }

    private Item createItem(BigDecimal productPrice){
        return new ItemByUnit(createProduct(productPrice));
    }

    private Product createProduct(BigDecimal productPrice){
        return new Product(productPrice);
    }
}