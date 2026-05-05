package LLDPractise.LinkedIn.Entities;

import LLDPractise.LinkedIn.Enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private final String id;
    private final String memberId;
    private final NotificationType notificationType;
    private final String content;
    private final LocalDateTime createdAt;
    private boolean isRead = false;

    public Notification(String memberId, NotificationType notificationType, String content) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.notificationType = notificationType;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }


    public boolean isRead() {
        return isRead;
    }

    public String getContent() {
        return content;
    }

    public void markAsRead(){
        this.isRead = true;
    }
}
