package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    public ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal getPrice() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Product getProduct() {
        return product;
    }

}
