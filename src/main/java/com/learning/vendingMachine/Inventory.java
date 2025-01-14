package com.learning.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    private Map<Integer, Rack> racks;

    private Inventory() {
        racks = new HashMap<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }

    public void addProduct(Product product, int rackNumber) {
        synchronized (this) {
            Rack rack = racks.get(rackNumber);
            if (rack == null) {
                throw new IllegalArgumentException("Rack " + rackNumber + " not found");
            }

            if (!rack.addProduct(product)) {
                throw new IllegalStateException("Failed to add product to rack " + rackNumber + ". Rack might be full.");
            }
        }
    }

    public Product removeProduct(int rackNumber, int position) {
        synchronized (this) {
            Rack rack = racks.get(rackNumber);
            if (rack == null) {
                throw new IllegalArgumentException("Rack " + rackNumber + " not found");
            }

            Product removedProduct = rack.removeProductAtPosition(position);
            if (removedProduct == null) {
                throw new IllegalStateException("No product found at position " + position + " in rack " + rackNumber);
            }

            return removedProduct;
        }
    }

    // Method to add a new rack
    public void addRack(Rack rack) {
        synchronized (this) {
            if (racks.containsKey(rack.getRackNumber())) {
                throw new IllegalArgumentException("Rack " + rack.getRackNumber() + " already exists");
            }
            racks.put(rack.getRackNumber(), rack);
        }
    }

    // Get all products in a specific rack
    public List<Product> getProductsInRack(int rackNumber) {
        Rack rack = racks.get(rackNumber);
        if (rack == null) {
            throw new IllegalArgumentException("Rack " + rackNumber + " not found");
        }
        return rack.getProducts();
    }

    // Get total number of products across all racks
    public int getTotalProductCount() {
        return racks.values().stream()
                .mapToInt(Rack::getNumberOfProducts)
                .sum();
    }

    // Find products by type across all racks
    public Map<Integer, List<Product>> findProductsByType(ProductType type) {
        Map<Integer, List<Product>> result = new HashMap<>();
        racks.forEach((rackNumber, rack) -> {
            List<Product> products = rack.getProductsByType(type);
            if (!products.isEmpty()) {
                result.put(rackNumber, products);
            }
        });
        return result;
    }

    // Check if a specific rack has capacity
    public boolean hasRackCapacity(int rackNumber) {
        Rack rack = racks.get(rackNumber);
        if (rack == null) {
            throw new IllegalArgumentException("Rack " + rackNumber + " not found");
        }
        return !rack.isFull();
    }
}