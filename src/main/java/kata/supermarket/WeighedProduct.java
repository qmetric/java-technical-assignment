package kata.supermarket;

import kata.supermarket.discount.DiscountScheme;

import java.math.BigDecimal;

public class WeighedProduct implements Product{

    private final BigDecimal pricePerKilo;
    private DiscountScheme discountScheme;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    @Override
    public void setDiscountScheme(DiscountScheme discountScheme) {
        this.discountScheme = discountScheme;
    }

    @Override
    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }
}
