package LLDPractise.MeetingSchedular.Strategy;

import LLDPractise.MeetingSchedular.Entites.MeetingRoom;
import LLDPractise.MeetingSchedular.Entites.User;
import LLDPractise.MeetingSchedular.Entites.TimeSlot;
import java.util.List;

class FCFSBookingStrategy implements BookingStrategy{

    @Override
    public MeetingRoom selectRoom(List<MeetingRoom> rooms, User user, int participants, TimeSlot slot) {
        for(MeetingRoom room: rooms){
            if(room.canBook(user, participants) && room.isAvailable(slot)){
                return room;
            }
        }
        return null;
    }
}
