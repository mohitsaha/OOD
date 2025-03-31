package com.learning.booking;

public class PlatinumSeat extends Seat {
    private static final double PLATINUM_RATE = 400.0;
    private static final double PLATINUM_MULTIPLIER = 1.5;

    public PlatinumSeat(String seatNo) {
        super(seatNo);
    }

    @Override
    public void setRate() {
        this.rate = PLATINUM_RATE;
    }

    @Override
    public double calculatePrice() {
        return rate * PLATINUM_MULTIPLIER;
    }
}
