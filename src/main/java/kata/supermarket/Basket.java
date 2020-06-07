package kata.supermarket;

import kata.supermarket.pricecaluator.PriceCalcuator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket extends PriceCalcuator {
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public void caluateSubTotal(){}

    @Override
    public BigDecimal caluateTotalToPay(){
        return null;
    }



}
