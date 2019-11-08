package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void emptyBasketHasZeroTotal() {
        assertEquals(BigDecimal.ZERO, new Basket().total());
    }
}