package kata.supermarket.offers;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static kata.supermarket.TestData.aPintOfMilk;
import static kata.supermarket.TestData.milkProduct;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Asif Akhtar
 * 29/04/2020 00:30
 */
public class BuyOneGetOneFreeOfferTest {

    @Test
    public void should_not_apply_discount_for_no_items() {
        Offer offer = new BuyOneGetOneFreeOffer(milkProduct().productSku());
        assertThat(offer.applyOffer(Collections.emptyList()), is(BigDecimal.ZERO));
    }

    @Test
    public void should_not_apply_discount_for_single_item() {
        Offer offer = new BuyOneGetOneFreeOffer(milkProduct().productSku());
        assertThat(offer.applyOffer(singletonList(aPintOfMilk())), is(new BigDecimal("0.00")));
    }

    @Test
    public void should_apply_discount_for_2_matching_items() {
        Offer offer = new BuyOneGetOneFreeOffer(milkProduct().productSku());
        assertThat(offer.applyOffer(asList(aPintOfMilk(), aPintOfMilk())), is(new BigDecimal("0.49")));
    }

    @Test
    public void should_apply_discount_for_1_matching_set_of_items() {
        Offer offer = new BuyOneGetOneFreeOffer(milkProduct().productSku());
        assertThat(offer.applyOffer(asList(aPintOfMilk(), aPintOfMilk(), aPintOfMilk())), is(new BigDecimal("0.49")));
    }

}