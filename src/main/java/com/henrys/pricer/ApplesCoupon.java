package com.henrys.pricer;

import java.time.LocalDate;
import java.util.List;

class ApplesCoupon extends Coupon {

    private final LocalDate validFromDate;
    private final LocalDate validToDate;

    protected ApplesCoupon(LocalDate validFromDate, LocalDate validToDate) {
        this.validFromDate = validFromDate;
        this.validToDate = validToDate;
    }

    @Override
    double calculateDiscount(List<BasketItem> items, LocalDate purchaseDate) {

        if (isNotApplicable(purchaseDate, this.validFromDate, this.validToDate))
            return 0;

        return numberOfApples(items) * .01;
    }

    private int numberOfApples(List<BasketItem> basketItems) {
        return basketItems.stream().filter(item ->
            item.getItem().equals(StockItem.APPLES)
        ).findFirst().orElse(new BasketItem(StockItem.APPLES, 0)).getQuantity();
    }

}