package com.learning.booking;

public abstract class Seat {
    // Data members
    private String seatNo;
    private SeatStatus status;
    protected double rate;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.status = SeatStatus.AVAILABLE;
        setRate(); // Set the rate based on seat type
    }

    // Member functions
    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public abstract void setRate();

    public double calculatePrice() {
        return rate;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNo='" + seatNo + '\'' +
                ", status=" + status +
                ", rate=" + rate +
                '}';
    }

    public void setAvailable(boolean b) {

    }
}
