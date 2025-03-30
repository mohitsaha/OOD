package com.learning.meetingSchdeuler;

import java.util.ArrayList;
import java.util.List;

public class Calender {
    List<Meeting> meetingList;
    private static Calender calender = null;

    private Calender() {
        this.meetingList = new ArrayList<>();
    }

    public static Calender getInstance() {
        if (calender == null) {
            calender = new Calender();
        }
        return calender;
    }   

    public void addMeeting(Meeting meeting) {
        meetingList.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetingList.remove(meeting);
    }
}
