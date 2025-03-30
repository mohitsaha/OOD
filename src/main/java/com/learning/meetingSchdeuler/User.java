package com.learning.meetingSchdeuler;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Meeting> meetings;
    private MeetingSchdeuler meetingScheduler;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.meetings = new ArrayList<>();
        this.meetingScheduler = MeetingSchdeuler.getInstance();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    public boolean hasMeetingConflict(Interval interval) {
        for (Meeting meeting : meetings) {
            if (isOverlapping(meeting.getInterval(), interval)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.getStartTime().before(interval2.getEndTime()) &&
               interval2.getStartTime().before(interval1.getEndTime());
    }

    public void respondInvitation(Notification invite, boolean accept) {
        if (accept) {
            // Handle acceptance
            System.out.println(name + " accepted the meeting invitation");
        } else {
            // Handle rejection
            System.out.println(name + " declined the meeting invitation");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
