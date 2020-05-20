// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountScheme {

    BigDecimal apply(List<Item> items);

}
