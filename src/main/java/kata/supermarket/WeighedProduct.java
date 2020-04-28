package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {
    private final String sku;
    private final BigDecimal pricePerKilo;

    public WeighedProduct(final String sku, final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
        this.sku = sku;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public String productSku() {
        return sku;
    }
}
