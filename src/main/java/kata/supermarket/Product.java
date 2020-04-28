package kata.supermarket;

import java.math.BigDecimal;

public class Product {
    private final BigDecimal pricePerUnit;
    private final String sku;

    public Product(final String sku, final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.sku = sku;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public String productSku() {
        return sku;
    }
}
