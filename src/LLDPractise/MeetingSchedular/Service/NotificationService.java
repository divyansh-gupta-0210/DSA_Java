package LLDPractise.MeetingSchedular.Service;

import LLDPractise.MeetingSchedular.Entites.User;

import java.util.List;

public class NotificationService {
    public static void notifyUser(List<User> participants, String message){
        for(User user: participants){
            System.out.println("Notify " + user.name + ": " + message);
        }
    }
}
