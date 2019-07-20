package com.nanoboost.nanopay;

public class MockProduct implements ProductInterface {

    private String mProductName,
    private String mImageName,
    private String mPriceString,
    private int mOrderNumber,
    private String mBuyerName,
    private int mProductStatus

    public MockProduct (String productName,
                 String imageName,
                 String priceString,
                 int orderNumber,
                 String buyerName,
                 int productStatus) {
        MockProduct instance = new MockProduct();
        instance.mProductName = productName;
        instance.mImageName = imageName;
        instance.mPriceString = priceString;
        instance.mOrderNumber = orderNumber;
        instance.mBuyerName = buyerName;
        instance.mProductStatus = productStatus;

        return instance;
    }

    @Override
    public String productName() {
        return mProductName;
    }

    @Override
    public String imageName() {
        return mImageName;
    }

    @Override
    public String priceString() {
        return mPriceString;
    }

    @Override
    public int orderNumber() {
        return mOrderNumber;
    }

    @Override
    public String buyerName() {
        return mBuyerName;
    }

    @Override
    public int productStatus() {
        return mProductStatus;
    }
}
