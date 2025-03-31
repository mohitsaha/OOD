package com.learning.booking;

public class GoldSeat extends Seat {
    private static final double GOLD_RATE = 300.0;
    private static final double GOLD_MULTIPLIER = 1.2;

    public GoldSeat(String seatNo) {
        super(seatNo);
    }

    @Override
    public void setRate() {
        this.rate = GOLD_RATE;
    }

    @Override
    public double calculatePrice() {
        return rate * GOLD_MULTIPLIER;
    }
}
