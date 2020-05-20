// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountScheme {

//    BUY_ONE_GET_ONE_FREE,
//    BUY_TWO_ITEMS_FOR_ONE_POUND,
//    BUY_THREE_ITEMS_FOR_TWO,
//    BUY_ONE_KG_FOR_HALF_PRICE;

    BigDecimal apply(List<Item> items) ;

}
