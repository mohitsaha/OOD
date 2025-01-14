package com.learning.vendingMachine;

public class Product {
    int productID;
    String productName;
    double productPrice;
    ProductType productType;

    public Product(String cola, int i, double v, ProductType productType) {
        this.productName = cola;
        this.productID = i;
        this.productPrice = v;
    }

    public ProductType getType() {
        return productType;
    }

    public String getName() {
        return null;
    }
}
