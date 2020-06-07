package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public interface DiscoutBuyOneGetOneFree {
    BigDecimal discount_BuyOneGetOneFree(List<Item> basket);
}
