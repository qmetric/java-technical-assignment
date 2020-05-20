package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import kata.supermarket.discount.BuyOneGetOneFreeScheme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(noItems(),
                         aSingleItemPricedPerUnit(),
                         multipleItemsPricedPerUnit(),
                         aSingleItemPricedByWeight(),
                         multipleItemsPricedByWeight(),
                         multipleEvenItemsWithBuyOneGetOneFreeSchemePricedPerUnit(),
                         multipleOddItemsWithBuyOneGetOneFreeSchemePricedPerUnit());
    }

    private static Arguments multipleEvenItemsWithBuyOneGetOneFreeSchemePricedPerUnit() {
        List<Item> totalItems = new ArrayList<>();
        totalItems.addAll(twoDigestivesWithBuyOneGetOneDiscountScheme());
        totalItems.addAll(twoPintOfMilkWithBuyOneGetOneFreeScheme());
        return Arguments.of("multiple pair of items with buy one get one free scheme priced per unit",
                            "2.04",
                            totalItems);
    }
    private static Arguments multipleOddItemsWithBuyOneGetOneFreeSchemePricedPerUnit() {
        List<Item> totalItems = new ArrayList<>();
        totalItems.add(aDigestivesWithBuyOneGetOneDiscountScheme());
        totalItems.addAll(twoPintOfMilkWithBuyOneGetOneFreeScheme());
        return Arguments.of("multiple even items with buy one get one free scheme priced per unit",
                            "2.04",
                            totalItems);
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85", Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix()));
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04", Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new CountableProduct(new BigDecimal("0.49")).oneOf();
    }

    private static List<Item> twoPintOfMilkWithBuyOneGetOneFreeScheme() {
        CountableProduct pintOfMilk = new CountableProduct(new BigDecimal("0.49"));
        pintOfMilk.setDiscountScheme(new BuyOneGetOneFreeScheme());
        Item item1 = pintOfMilk.oneOf();
        Item item2 = pintOfMilk.oneOf();
        return Arrays.asList(item1, item2);
    }

    private static Item aPackOfDigestives() {
        return new CountableProduct(new BigDecimal("1.55")).oneOf();
    }

    private static List<Item> twoDigestivesWithBuyOneGetOneDiscountScheme() {
        CountableProduct digestives = new CountableProduct(new BigDecimal("1.55"));
        digestives.setDiscountScheme(new BuyOneGetOneFreeScheme());
        Item item1 = digestives.oneOf();
        Item item2 = digestives.oneOf();
        return Arrays.asList(item1, item2);
    }

    private static Item aDigestivesWithBuyOneGetOneDiscountScheme() {
        CountableProduct digestives = new CountableProduct(new BigDecimal("1.55"));
        digestives.setDiscountScheme(new BuyOneGetOneFreeScheme());

        return digestives.oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}