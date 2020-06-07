package kata.supermarket;

import kata.supermarket.discounts.DiscoutBuyOneGetOneFree;
import kata.supermarket.pricecaluator.PriceCalcuator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket extends PriceCalcuator {
    private final List<Item> items;

    public Basket(DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree) {
        super(discoutBuyOneGetOneFree);
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public BigDecimal caluateSubTotal(){
        items.stream().forEach(e -> foo(e));
        return sub_Total;
    }

    @Override
    public BigDecimal caluateTotalToPay(){

        BigDecimal total = discoutBuyOneGetOneFree.discount_BuyOneGetOneFree(items);

        return total;

    }

    private void foo(Item price){
         sub_Total = sub_Total.add(price.price());
    }



}
