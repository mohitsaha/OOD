package com.learning.meetingSchdeuler;

import java.util.List;

public class Meeting {
    private User organizer;
    private List<User> participants;
    private Interval interval;
    private String agenda;
    private MeetingRoom meetingRoom;
    private String meetingId;

    public Meeting(User organizer, List<User> participants, Interval interval, String agenda, MeetingRoom meetingRoom) {
        this.organizer = organizer;
        this.participants = participants;
        this.interval = interval;
        this.agenda = agenda;
        this.meetingRoom = meetingRoom;
        this.meetingId = generateMeetingId();
    }

    private String generateMeetingId() {
        return "MEET-" + System.currentTimeMillis() + "-" + organizer.getName().substring(0, 3).toUpperCase();
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Interval getInterval() {
        return interval;
    }

    public String getAgenda() {
        return agenda;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public boolean addParticipant(User user) {
        if (!participants.contains(user)) {
            participants.add(user);
            return true;
        }
        return false;
    }

    public boolean removeParticipant(User user) {
        return participants.remove(user);
    }

    public boolean isParticipant(User user) {
        return participants.contains(user);
    }
}
