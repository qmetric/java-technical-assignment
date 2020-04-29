package kata.supermarket.offers;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
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

        List<Item> matchingOffers = items.stream().filter(item -> item.productSku().equals(productSku)).collect(Collectors.toList());
        int discountable = (int) matchingOffers.size() / 2;
        return scaleCurrency(BigDecimal.valueOf(discountable).multiply(matchingOffers.get(0).price()));
    }
}
