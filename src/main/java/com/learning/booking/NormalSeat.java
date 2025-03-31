package com.learning.booking;

public class NormalSeat extends Seat {
    private static final double NORMAL_RATE = 200.0;

    public NormalSeat(String seatNo) {
        super(seatNo);
    }


    @Override
    public void setRate() {
        this.rate = NORMAL_RATE;
    }
}
