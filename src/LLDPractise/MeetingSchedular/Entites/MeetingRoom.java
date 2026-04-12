package LLDPractise.MeetingSchedular.Entites;

import java.util.ArrayList;
import java.util.List;

public abstract class MeetingRoom {
    public String id;
    public int capacity;
    public List<Meeting> meetingList = new ArrayList<>();

    public MeetingRoom(String id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }

    public boolean canFit(int participants){
        return participants <= capacity;
    }

    public void addMeeting(Meeting meeting) {
        meetingList.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetingList.remove(meeting);
    }


    public boolean isAvailable(TimeSlot timeSlot){
        for(Meeting m: meetingList){
            if(m.getTimeSlot().overLaps(timeSlot)){
                return true;
            }
        }
        return false;
    }

    public Meeting getConflictingMeeting(TimeSlot timeSlot){
        for(Meeting m: meetingList){
            if(m.getTimeSlot().overLaps(timeSlot)){
                return m;
            }
        }
        return null;
    }

    public abstract boolean canBook(User user, int participants);
}

