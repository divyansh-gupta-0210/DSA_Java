package LLDPractise.MeetingSchedular.Service;

import LLDPractise.MeetingSchedular.Entites.Meeting;
import LLDPractise.MeetingSchedular.Entites.MeetingRoom;
import LLDPractise.MeetingSchedular.Entites.TimeSlot;
import LLDPractise.MeetingSchedular.Entites.User;
import LLDPractise.MeetingSchedular.Strategy.BookingStrategy;
import LLDPractise.MeetingSchedular.Strategy.PreemptionPolicy;

import java.util.List;

public class BookingService {
    public List<MeetingRoom> rooms;
    public BookingStrategy bookingStrategy;
    PreemptionPolicy policy;

    public BookingService(List<MeetingRoom> meetingRooms,  PreemptionPolicy policy){
        this.rooms = meetingRooms;
//        this.bookingStrategy = bookingStrategy;
        this.policy = policy;
    }

    public Meeting bookMeeting(String meetingId, User user, List<User> participants, TimeSlot timeSlot){

        for(MeetingRoom room : rooms){
            if (!room.canFit(participants.size())) continue;
            Meeting conflict = room.getConflictingMeeting(timeSlot);
            if(conflict == null){
                Meeting meeting = createMeeting(meetingId, user, participants, timeSlot, room);
                room.addMeeting(meeting);
                NotificationService.notifyUser(participants, "Meeting scheduled at " + timeSlot.start + " till " + timeSlot.end);
                return meeting;
            }
            if(policy.canPreempt(user, conflict)){
                System.out.println("Preempting meeting in room: " + room.id);
                cancelMeeting(conflict);
                Meeting meeting = createMeeting(meetingId, user, participants, timeSlot, room);
                room.addMeeting(meeting);
                NotificationService.notifyUser(participants, "Meeting scheduled at " + timeSlot.start + " till " + timeSlot.end);
                return meeting;
            }
        }

        return null;
    }

    private Meeting createMeeting(String id, User user, List<User> participants, TimeSlot slot, MeetingRoom room) {
        return new Meeting(id, slot, participants, room,user);
    }

    public void cancelMeeting(Meeting meeting){
        meeting.room.meetingList.remove(meeting);
        NotificationService.notifyUser(meeting.participants, "Meeting is cancelled");
    }

}
