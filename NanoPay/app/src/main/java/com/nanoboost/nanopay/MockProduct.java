package com.nanoboost.nanopay;

public class MockProduct implements ProductInterface {

    private String mProductName;
    private String mImageName;
    private String mPriceString;
    private int mOrderNumber;
    private String mBuyerName;
    private int mProductStatus;

    public MockProduct (String productName,
                 String imageName,
                 String priceString,
                 int orderNumber,
                 String buyerName,
                 int productStatus) {
        this.mProductName = productName;
        this.mImageName = imageName;
        this.mPriceString = priceString;
        this.mOrderNumber = orderNumber;
        this.mBuyerName = buyerName;
        this.mProductStatus = productStatus;
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
