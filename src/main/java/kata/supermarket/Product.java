// Copyright (c) 2020 Travelex Ltd

package kata.supermarket;

import kata.supermarket.discount.DiscountScheme;

public interface Product {

    void setDiscountScheme(DiscountScheme discountScheme);

    DiscountScheme getDiscountScheme();

}
