package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscoutBuyOneGetOneFreeImpl implements DiscoutBuyOneGetOneFree {
    List<BigDecimal> dList = new ArrayList();

    @Override
    public BigDecimal discount_BuyOneGetOneFree(List<Item> basket) {

        BigDecimal totalDiscount = new BigDecimal("0.00");

        basket.stream().forEach(e -> createPriceSet(e));

        Set<BigDecimal> se = new HashSet(dList);

        for(BigDecimal dec : se){
            BigDecimal price = dec;
            totalDiscount = totalDiscount.add(price);
        }

        return totalDiscount;
    }

    private void createPriceSet(Item item){
        dList.add(item.price());
    }
}
