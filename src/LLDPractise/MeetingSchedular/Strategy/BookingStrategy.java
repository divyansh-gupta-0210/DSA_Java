package LLDPractise.MeetingSchedular.Strategy;

import LLDPractise.MeetingSchedular.Entites.MeetingRoom;
import LLDPractise.MeetingSchedular.Entites.User;
import LLDPractise.MeetingSchedular.Entites.TimeSlot;
import java.util.List;

public interface BookingStrategy {
    MeetingRoom selectRoom(List<MeetingRoom> rooms, User user, int participants, TimeSlot slot);
}