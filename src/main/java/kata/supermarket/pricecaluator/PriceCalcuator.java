package kata.supermarket.pricecaluator;

import kata.supermarket.discounts.DiscoutBuyOneGetOneFree;

import java.math.BigDecimal;

public abstract class PriceCalcuator {

    private BigDecimal subtotal;

    private DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree;

    protected abstract void caluateSubTotal();

    protected abstract BigDecimal caluateTotalToPay();


}
