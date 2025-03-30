package com.learning.meetingSchdeuler;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String roomName;
    private int capacity;
    private boolean isAvailable;
    private List<Interval> bookedIntervals;

    public MeetingRoom(String roomName, int capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.isAvailable = true;
        this.bookedIntervals = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Interval> getBookedIntervals() {
        return bookedIntervals;
    }

    public boolean isAvailableForInterval(Interval interval) {
        for (Interval booked : bookedIntervals) {
            if (isOverlapping(booked, interval)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.getStartTime().before(interval2.getEndTime()) &&
               interval2.getStartTime().before(interval1.getEndTime());
    }

    public void bookInterval(Interval interval) {
        bookedIntervals.add(interval);
    }

    public void releaseInterval(Interval interval) {
        bookedIntervals.remove(interval);
    }
}
