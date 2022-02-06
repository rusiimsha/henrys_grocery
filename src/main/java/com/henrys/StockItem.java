package com.henrys;

enum StockItem {

    SOUP(0.65), BREAD(0.80);

    private double cost;

    StockItem(double cost) {
        this.cost = cost;
    }

}
