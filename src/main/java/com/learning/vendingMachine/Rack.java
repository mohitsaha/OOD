package com.learning.vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rack {
    private List<Product> products;
    private int rackNumber;
    private int capacity;

    public Rack(int rackNumber, int capacity) {
        this.rackNumber = rackNumber;
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public boolean isFull() {
        return products.size() >= capacity;
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (isFull()) {
            return false;
        }
        return products.add(product);
    }

    public Product removeProduct(Product product) {
        if (products.remove(product)) {
            return product;
        }
        return null;
    }

    // Useful for removing a specific product by index (like in a vending machine)
    public Product removeProductAtPosition(int position) {
        if (position >= 0 && position < products.size()) {
            return products.remove(position);
        }
        return null;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public List<Product> getProducts() {
        // Return a defensive copy
        return new ArrayList<>(products);
    }

    public boolean containsProduct(Product product) {
        return products.contains(product);
    }

    // Useful for finding products by type or other criteria
    public List<Product> getProductsByType(ProductType type) {
        return products.stream()
                .filter(p -> p.getType() == type)
                .collect(Collectors.toList());
    }
}