package com.learning.booking;


enum PaymentStatus {
    PENDING,
    CONFIRMED,
    DECLINED,
    REFUNDED
}

enum BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    DENIED,
    REFUNDED
}

public enum SeatStatus {
    AVAILABLE,
    BOOKED,
    BLOCKED
}