// Copyright (c) 2020 Travelex Ltd

package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuyThreeItemsForTwoScheme implements DiscountScheme {

    private static BuyThreeItemsForTwoScheme INSTANCE;

    private BuyThreeItemsForTwoScheme(){}

    public static BuyThreeItemsForTwoScheme getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BuyThreeItemsForTwoScheme();
        }

        return INSTANCE;
    }
    @Override
    public BigDecimal apply(List<Item> items) {

        if (items == null || items.isEmpty()) {
            System.out.println("No Items available to apply discount to");
            return BigDecimal.ZERO;
        }

        BigDecimal totalDiscount = BigDecimal.ZERO;

        Map<Product, List<Item>> productMap = items.stream().collect(Collectors.groupingBy(item -> item.getProduct()));

        for (Map.Entry<Product, List<Item>> productMapEntry : productMap.entrySet()) {

            if (productMapEntry.getValue().size() < 3) {
                System.out.println("Less than three items found for this product. Hence discount cannot be applied.");
                continue;
            }

            int numberOfItemsToApplyDiscount = productMapEntry.getValue().size();

            totalDiscount = productMapEntry.getValue()
                                           .get(0)
                                           .getPrice()
                                           .multiply(BigDecimal.valueOf(numberOfItemsToApplyDiscount / 3))
                                           .add(totalDiscount);

        }

        return totalDiscount;
    }
}
