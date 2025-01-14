package com.learning.vendingMachine;

public class MoneyInsertedState implements VendingMachineState {
    VendingMachine vendingMachine;

    public MoneyInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Money already inserted");
        throw new IllegalStateException("Money already inserted");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        // check if product item is available
        // validate money
        // change state to DispenseState
    }

    @Override
    public void returnChange(double amount) {

    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {

    }
}
