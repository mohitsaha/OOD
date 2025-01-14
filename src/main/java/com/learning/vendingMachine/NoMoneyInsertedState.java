package com.learning.vendingMachine;

public class NoMoneyInsertedState implements VendingMachineState{

    VendingMachine vendingMachine;

    NoMoneyInsertedState(VendingMachine vendingMachine){
            this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
//        machine.setInsertedMoney(amount);
//        machine.setCurrentState(machine.getHasMoneyState());
        System.out.println(amount + " inserted");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("Please insert money first");
        throw  new IllegalStateException("Please insert money first");
    }

    @Override
    public void returnChange(double amount) {
        System.out.println("No money to return");
        throw new IllegalStateException("No money to return");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("Please insert money first");
        throw new IllegalStateException("Please insert money first");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Please insert money first");
        throw new IllegalStateException("Please insert money first");
    }
}
