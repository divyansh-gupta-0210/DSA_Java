package LLDPractise.MeetingSchedular.Entites;

import java.util.List;

public class Meeting {
    public String id;
    public TimeSlot timeSlot;
    public List<User> participants;
    public MeetingRoom room;
    public User organizer;

    public Meeting(String id, TimeSlot timeSlot, List<User> participants, MeetingRoom room, User organizer) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.participants = participants;
        this.room = room;
        this.organizer = organizer;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public int getPriority() {
        return organizer.getRole().priority;
    }

    public List<User> getParticipants() {
        return participants;
    }

}
