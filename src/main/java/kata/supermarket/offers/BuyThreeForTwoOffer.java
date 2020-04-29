package kata.supermarket.offers;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Asif Akhtar
 * 29/04/2020 01:13
 */
public class BuyThreeForTwoOffer implements Offer {
    private final String productSku;

    public BuyThreeForTwoOffer(String productSku) {
        this.productSku = productSku;
    }

    @Override
    public BigDecimal applyOffer(List<Item> items) {
        if (items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        long matchingProducts = items.stream().filter(item -> item.productSku().equals(productSku)).count();
        int discountable = (int) matchingProducts / 3;
        return scaleCurrency(BigDecimal.valueOf(discountable).multiply(items.get(0).price()));
    }
}
