package kata.supermarket;

import kata.supermarket.offers.Offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;
    private final List<Offer> offers;

    public Basket() {
        this.items = new ArrayList<>();
        this.offers = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    public void addOffer(final Offer offer) {
        this.offers.add(offer);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return scaleCurrency(items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO));
        }

        /**
         * TODO: This could be a good place to apply the results of
         * the discount calculations.
         * It is not likely to be the best place to do those calculations.
         * Think about how Basket could interact with something
         * which provides that functionality.
         */
        private BigDecimal discounts() {
            return scaleCurrency(offers.stream()
                    .map(offer -> offer.applyOffer(items))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO));
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }

        private BigDecimal scaleCurrency(BigDecimal value) {
            return value.setScale(2, RoundingMode.HALF_UP);
        }
    }
}
