// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuyOneGetOneFreeScheme implements DiscountScheme {

    @Override
    public BigDecimal apply(List<Item> items) {

        if (items == null || items.isEmpty()) {
            // Should use a LOGGER
            System.out.println("No Items available to apply discount to");
            return BigDecimal.ZERO;
        }

        BigDecimal totalDiscount = BigDecimal.ZERO;

        Map<Product, List<Item>> productMap = items.stream().collect(Collectors.groupingBy(item -> item.getProduct()));

        for (Map.Entry<Product, List<Item>> productMapEntry : productMap.entrySet()) {

            if (productMapEntry.getValue().size() == 1) {
                System.out.println("Only one item found for this product. Hence discount cannot be applied.");
                continue;
            }

            int numberOfItemsToApplyDiscount = productMapEntry.getValue().size();

            if (numberOfItemsToApplyDiscount % 2 != 0) {
                numberOfItemsToApplyDiscount--;
            }

            totalDiscount = productMapEntry.getValue()
                                           .get(0)
                                           .getPrice()
                                           .multiply(BigDecimal.valueOf(numberOfItemsToApplyDiscount))
                                           .divide(BigDecimal.valueOf(2))
                                           .add(totalDiscount);

        }

        return totalDiscount;
    }
}
