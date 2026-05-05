package LLDPractise.LinkedIn.Services;

import LLDPractise.LinkedIn.Entities.Notification;
import LLDPractise.LinkedIn.Entities.User;

public class NotificationService {
    public void sendNotification(User user, Notification notification){
        user.update(notification);
    }
}
