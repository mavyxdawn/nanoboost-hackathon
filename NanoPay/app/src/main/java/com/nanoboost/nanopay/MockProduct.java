package com.nanoboost.nanopay;

public class MockProduct implements ProductInterface {

    @Override
    public String productName() {
        return "Rolex Watch";
    }

    @Override
    public String imageName() {
        return "watch";
    }

    @Override
    public String priceString() {
        return "₱3.99";
    }

    @Override
    public int orderNumber() {
        return 923012321;
    }

    @Override
    public String buyerName() {
        return "Von Caro";
    }

    @Override
    public int productStatus() {
        return 1;
    }
}
