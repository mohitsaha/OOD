package com.learning.meetingSchdeuler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create users
        User mohit = new User("mohit", "mohit@gmail.com");
        User ansh = new User("ansh", "ansh@gmail.com");
        User suraj = new User("suraj", "suraj@gmail.com");

        // Create meeting room
        MeetingRoom room1 = new MeetingRoom("gupsup", 10);

        // Create meeting scheduler instance
        MeetingSchdeuler scheduler = MeetingSchdeuler.getInstance();

        // Create meeting interval
        Interval meetingTime = new Interval(new Date(), new Date(System.currentTimeMillis() + 3600000)); // 1 hour meeting

        // Create participants list
        List<User> participants = new ArrayList<>();
        participants.add(ansh);
        participants.add(suraj);

        // Schedule a meeting
        boolean scheduled = scheduler.schdeuleMeeting(mohit, participants, meetingTime);
        System.out.println("Meeting scheduled: " + scheduled);
    }
}
