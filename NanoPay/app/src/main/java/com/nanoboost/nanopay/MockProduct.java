package com.nanoboost.nanopay;

public class MockProduct implements ProductInterface {

    @Override
    public String productName() {
        return "Rolex Watch";
    }

    @Override
    public String imageName() {
        return "watch.png";
    }

    @Override
    public float price() {
        return 3.99f;
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
