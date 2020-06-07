package kata.supermarket.pricecaluator;

import kata.supermarket.discounts.DiscoutBuyOneGetOneFree;

import java.math.BigDecimal;

public abstract class PriceCalcuator {

    public PriceCalcuator(DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree){
        this.discoutBuyOneGetOneFree = discoutBuyOneGetOneFree;
    }

    protected BigDecimal sub_Total;

    protected DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree;

    protected abstract void caluateSubTotal();

    protected abstract BigDecimal caluateTotalToPay();


}
