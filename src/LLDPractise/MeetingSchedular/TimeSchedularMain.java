package LLDPractise.MeetingSchedular;

import LLDPractise.MeetingSchedular.Entites.*;
import LLDPractise.MeetingSchedular.Service.BookingService;
import LLDPractise.MeetingSchedular.Strategy.PreemptionPolicy;

import java.util.*;


public class TimeSchedularMain {
    public static void main(String[] args) {
        User normalUser = new User("1", "Normal User", Role.NORMAL);
        User vipUser = new User("2", "VIP User", Role.VIP);
        User vvipUser = new User("3", "VVIP User", Role.VVIP);

        MeetingRoom room = new VIPRoom("Room-A", 10);

        List<MeetingRoom> rooms = Arrays.asList(room);
        BookingService service = new BookingService(
                rooms,
                new PreemptionPolicy()
        );

        TimeSlot slot = new TimeSlot(10, 11);

        service.bookMeeting("M1", normalUser, Arrays.asList(normalUser), slot);
        TimeSlot slot2 = new TimeSlot(10, 11);
        service.bookMeeting("M2", vipUser, Arrays.asList(vipUser), slot2);

        TimeSlot slot3 = new TimeSlot(10, 11);
        service.bookMeeting("M3", vvipUser, Arrays.asList(vvipUser), slot3);
    }
}
