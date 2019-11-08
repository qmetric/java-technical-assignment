package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    void add(final Item item) {
        items.add(item);
    }

    private List<Item> currentItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new SimpleCalculator(currentItems()).total();
    }

    static class SimpleCalculator {
        private final List<Item> items;

        SimpleCalculator(final List<Item> items) {
            this.items = items;
        }

        BigDecimal total() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);
        }
    }
}
