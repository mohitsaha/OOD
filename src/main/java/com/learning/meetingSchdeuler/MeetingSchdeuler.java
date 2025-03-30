package com.learning.meetingSchdeuler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MeetingSchdeuler {
    private Calendar calendar;
    private List<MeetingRoom> rooms;
    private static MeetingSchdeuler scheduler = null;
    private List<Meeting> meetings;

    private MeetingSchdeuler() {
        this.calendar = Calendar.getInstance();
        this.rooms = new ArrayList<>();
        rooms.add(new MeetingRoom("gupsup",4));
        rooms.add(new MeetingRoom("triton",4));
        this.meetings = new ArrayList<>();
    }

    public static MeetingSchdeuler getInstance() {
        if (scheduler == null) {
            scheduler = new MeetingSchdeuler();
        }
        return scheduler;
    }

    public boolean schdeuleMeeting(User organizer, List<User> participants, Interval interval) {
        // Check if organizer has any conflicts
        if (organizer.hasMeetingConflict(interval)) {
            return false;
        }

        // Check if any participant has conflicts
        for (User participant : participants) {
            if (participant.hasMeetingConflict(interval)) {
                return false;
            }
        }

        // Find available room
        List<MeetingRoom> availableRooms = checkRoomsAvailability(participants.size(), interval);
        if (availableRooms.isEmpty()) {
            return false;
        }

        // Book the first available room
        MeetingRoom selectedRoom = availableRooms.get(0);
        if (!bookRoom(selectedRoom, participants.size(), interval)) {
            return false;
        }

        // Create and schedule the meeting
        Meeting meeting = new Meeting(organizer, participants, interval, "Meeting", selectedRoom);
        meetings.add(meeting);
        organizer.addMeeting(meeting);
        for (User participant : participants) {
            participant.addMeeting(meeting);
        }

        // Send notifications
        sendMeetingNotifications(meeting);

        return true;
    }

    public boolean cancelMeeting(Meeting meeting) {
        if (!meetings.contains(meeting)) {
            return false;
        }

        // Release the room
        releaseRoom(meeting.getMeetingRoom(), meeting.getInterval());

        // Remove meeting from all participants
        meeting.getOrganizer().removeMeeting(meeting);
        for (User participant : meeting.getParticipants()) {
            participant.removeMeeting(meeting);
        }

        // Remove meeting from scheduler
        meetings.remove(meeting);

        // Send cancellation notifications
        sendCancellationNotifications(meeting);

        return true;
    }

    private boolean bookRoom(MeetingRoom room, int numberOfPersons, Interval interval) {
        if (room.getCapacity() < numberOfPersons || !room.isAvailableForInterval(interval)) {
            return false;
        }
        room.bookInterval(interval);
        return true;
    }

    private boolean releaseRoom(MeetingRoom room, Interval interval) {
        room.releaseInterval(interval);
        return true;
    }

    private List<MeetingRoom> checkRoomsAvailability(int numberOfPersons, Interval interval) {
        List<MeetingRoom> availableRooms = new ArrayList<>();
        for (MeetingRoom room : rooms) {
            if (room.getCapacity() >= numberOfPersons && room.isAvailableForInterval(interval)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private void sendMeetingNotifications(Meeting meeting) {
        Notification notification = new Notification("Meeting scheduled", meeting.getInterval());
        notification.sendNotification(meeting.getOrganizer());
        for (User participant : meeting.getParticipants()) {
            notification.sendNotification(participant);
        }
    }

    private void sendCancellationNotifications(Meeting meeting) {
        Notification notification = new Notification("Meeting cancelled", meeting.getInterval());
        notification.cancelNotification(meeting.getOrganizer());
        for (User participant : meeting.getParticipants()) {
            notification.cancelNotification(participant);
        }
    }

    public void addMeetingRoom(MeetingRoom room) {
        rooms.add(room);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
