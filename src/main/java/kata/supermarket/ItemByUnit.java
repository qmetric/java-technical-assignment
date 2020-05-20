package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final CountableProduct countableProduct;

    public ItemByUnit(final CountableProduct countableProduct) {
        this.countableProduct = countableProduct;
    }

    public BigDecimal getPrice() {
        return countableProduct.pricePerUnit();
    }

    @Override
    public Product getProduct() {
        return countableProduct;
    }

}
