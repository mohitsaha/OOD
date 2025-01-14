package com.learning.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private final Inventory inventory;
    private double currentBalance;
    private Map<Product, Double> productPrices;

    // States
    private VendingMachineState currentState;
    private VendingMachineState noMoneyState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispenseState;

    private VendingMachine() {
        this.inventory = Inventory.getInstance();
        this.currentBalance = 0.0;
        this.productPrices = new HashMap<>();

        // Initialize states
        this.noMoneyState = new NoMoneyInsertedState(this);
        this.hasMoneyState = new MoneyInsertedState(this);
        this.dispenseState = new DispenseState();

        // Set initial state
        this.currentState = noMoneyState;

        initializeInventory();
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            synchronized (VendingMachine.class) {
                if (instance == null) {
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }

    private void initializeInventory() {
        // Create and add racks
        for (int i = 1; i <= 5; i++) {
            inventory.addRack(new Rack(i, 10));
        }

        // Initialize with some products
        Product cola = new Product("Cola", 1, 1.50, ProductType.DRINK);
        Product chips = new Product("Chips", 2, 1.00, ProductType.SNACK);
        Product candy = new Product("Candy", 3, 0.75, ProductType.CANDY);

        productPrices.put(cola, 1.50);
        productPrices.put(chips, 1.00);
        productPrices.put(candy, 0.75);

        try {
            inventory.addProduct(cola, 1);
            inventory.addProduct(chips, 2);
            inventory.addProduct(candy, 3);
        } catch (IllegalStateException e) {
            System.out.println("Error initializing inventory: " + e.getMessage());
        }
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void pressButton(int rackNumber) {
        currentState.pressButton(this, rackNumber);
    }

    public void dispenseProduct(int rackNumber) {
        currentState.dispenseProduct(this, rackNumber);
    }

    public void returnChange() {
        currentState.returnChange(currentBalance);
        currentBalance = 0.0;
    }

    // Getters and setters for state management
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    // Money management
    public void setCurrentBalance(double amount) {
        this.currentBalance = amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getProductPrice(int rackNumber) {
        List<Product> products = inventory.getProductsInRack(rackNumber);
        if (!products.isEmpty()) {
            return productPrices.get(products.get(0));
        }
        throw new IllegalStateException("No product found in rack " + rackNumber);
    }

    public boolean isProductAvailable(int rackNumber) {
        return !inventory.getProductsInRack(rackNumber).isEmpty();
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nRack " + i + ":");
            List<Product> products = inventory.getProductsInRack(i);
            products.forEach(product ->
                    System.out.printf("- %s: $%.2f%n",
                            product.getName(),
                            productPrices.get(product)));
        }
    }
}