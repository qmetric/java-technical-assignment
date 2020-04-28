package kata.supermarket.offers;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Asif Akhtar
 * 29/04/2020 00:27
 */
@FunctionalInterface
public interface Offer {
    BigDecimal applyOffer(List<Item> items);
}
