package kata.supermarket;

import java.math.BigDecimal;

/**
 * @author Asif Akhtar
 * 29/04/2020 00:35
 */
public class TestData {

    public static Item aPintOfMilk() {
        return milkProduct().oneOf();
    }

    public static Product milkProduct() {
        return new Product("Milk", new BigDecimal("0.49"));
    }
}
