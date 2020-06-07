package kata.supermarket.pricecaluator;

import kata.supermarket.discounts.DiscoutBuyOneGetOneFree;

import java.math.BigDecimal;

abstract class PriceCalcuator {

    private BigDecimal subtotal;

    private DiscoutBuyOneGetOneFree discoutBuyOneGetOneFree;

    private void caluateSubTotal(){

    }

    public BigDecimal caluateTotalToPay(){
        return null;
    }


}
