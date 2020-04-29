package kata.supermarket;

import kata.supermarket.offers.BuyOneGetOneFreeOffer;
import kata.supermarket.offers.Offer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static kata.supermarket.TestData.aPintOfMilk;
import static kata.supermarket.TestData.milkProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                twoPintsOfMilkEligibleForOffer(),
                fourPintsOfMilkEligibleForOffer(),
                mixOfProductsSomeEligibleForBogof()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()), Collections.emptyList());
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
                , Collections.emptyList()
        );
    }

    private static Arguments twoPintsOfMilkEligibleForOffer() {
        return Arguments.of("2 pints of milk eligible for BOGOF offer", "0.49",
                Arrays.asList(aPintOfMilk(), aPintOfMilk()),
                Collections.singletonList(new BuyOneGetOneFreeOffer(milkProduct().productSku()))
        );
    }

    private static Arguments fourPintsOfMilkEligibleForOffer() {
        return Arguments.of("4 pints of milk eligible for BOGOF offer", "0.98",
                Arrays.asList(aPintOfMilk(), aPintOfMilk(), aPintOfMilk(), aPintOfMilk()),
                Collections.singletonList(new BuyOneGetOneFreeOffer(milkProduct().productSku()))
        );
    }

    private static Arguments mixOfProductsSomeEligibleForBogof() {
        return Arguments.of("mix of BOGOF and non eligible items", "2.04",
                Arrays.asList(aPintOfMilk(), aPintOfMilk(), aPackOfDigestives()),
                Collections.singletonList(new BuyOneGetOneFreeOffer(milkProduct().productSku()))
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()),
                Collections.emptyList());
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()), Collections.emptyList());
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList(), Collections.emptyList());
    }

    private static Item aPackOfDigestives() {
        return new Product("Digestives", new BigDecimal("1.55")).oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct("AmericanSweets", new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct("PickAndMix", new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items, Iterable<Offer> offers) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        offers.forEach(basket::addOffer);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }
}