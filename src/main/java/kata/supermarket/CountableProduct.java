package kata.supermarket;

import kata.supermarket.discount.DiscountScheme;

import java.math.BigDecimal;

public class CountableProduct implements Product{

    private final BigDecimal pricePerUnit;
    private DiscountScheme discountScheme;

    public CountableProduct(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
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
