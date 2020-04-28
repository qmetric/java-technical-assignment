package kata.supermarket.offers;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Asif Akhtar
 * 29/04/2020 00:29
 */
public class BuyOneGetOneFreeOffer implements Offer {
    private final String productSku;

    public BuyOneGetOneFreeOffer(String productSku) {
        this.productSku = productSku;
    }

    @Override public BigDecimal applyOffer(List<Item> items) {
        if (items.isEmpty()) {
            return BigDecimal.ZERO;
        }

        long matchingProducts = items.stream().filter(item -> item.productSku().equals(productSku)).count();
        int discountable = (int) matchingProducts / 2;
        return BigDecimal.valueOf(discountable).multiply(items.get(0).price());
    }
}
