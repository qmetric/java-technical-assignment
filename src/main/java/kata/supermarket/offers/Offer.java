package kata.supermarket.offers;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Asif Akhtar
 * 29/04/2020 00:27
 */
@FunctionalInterface
public interface Offer {
    BigDecimal applyOffer(List<Item> items);

    default BigDecimal scaleCurrency(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
