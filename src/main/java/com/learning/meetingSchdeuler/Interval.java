package com.learning.meetingSchdeuler;

import java.util.Date;

public class Interval {
    private Date startTime;
    private Date endTime;

    public Interval(Date startTime, Date endTime) {
        if (startTime.after(endTime)) {
            throw new IllegalArgumentException("Start time cannot be after end time");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public long getDuration() {
        return endTime.getTime() - startTime.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return startTime.equals(interval.startTime) && endTime.equals(interval.endTime);
    }

    @Override
    public int hashCode() {
        return startTime.hashCode() * 31 + endTime.hashCode();
    }
}
