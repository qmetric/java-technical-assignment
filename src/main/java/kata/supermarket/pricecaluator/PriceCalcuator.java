package kata.supermarket.pricecaluator;

import kata.supermarket.discounts.DiscoutBuyOneGetOneFree;

import java.math.BigDecimal;

public abstract class PriceCalcuator {

    public PriceCalcuator(DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree){
        this.discoutBuyOneGetOneFree = discoutBuyOneGetOneFree;
    }

    protected BigDecimal sub_Total = BigDecimal.ZERO;

    protected DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree;

    protected abstract BigDecimal caluateSubTotal();

    protected abstract BigDecimal caluateTotalToPay();


}
