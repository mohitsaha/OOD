package com.learning.meetingSchdeuler;

public class Notification {
    String Message;
    Interval interval;
    Notification(String Message, Interval interval){
        this.Message = Message;
        this.interval = interval;
    }
    public boolean sendNotification(User user) {
        System.out.println("Notification sent to " + user.getName());
        return false;
    }

    public boolean cancelNotification(User user) {
        System.out.println("cancel Notification sent to " + user.getName());
        return false;
    }

}
