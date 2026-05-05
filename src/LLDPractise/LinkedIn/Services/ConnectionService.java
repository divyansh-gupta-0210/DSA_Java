package LLDPractise.LinkedIn.Services;

import LLDPractise.LinkedIn.Entities.Connection;
import LLDPractise.LinkedIn.Entities.Notification;
import LLDPractise.LinkedIn.Entities.User;
import LLDPractise.LinkedIn.Enums.ConnectionStatus;
import LLDPractise.LinkedIn.Enums.NotificationType;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionService {

    private final NotificationService notificationService;
    private final Map<String, Connection> connectionRequests = new ConcurrentHashMap<>();

    public ConnectionService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public String sendRequest(User from, User to){
        Connection connection = new Connection(from, to);
        String requestId = UUID.randomUUID().toString();
        connectionRequests.put(requestId, connection);
        System.out.printf("%s sent a connection request to %s.%n", from.getName(), to.getName());

        Notification notification = new Notification(to.getId(), NotificationType.CONNECTION_REQUEST, from.getName() + " wants to connect with you. RequestId: " + requestId);
        notificationService.sendNotification(to, notification);
        return requestId;
    }

    public void acceptRequest(String requestId){
        Connection request = connectionRequests.get(requestId);
        if(request != null && request.getStatus() == ConnectionStatus.PENDING){
            request.setStatus(ConnectionStatus.ACCEPTED);
            User from = request.getFromMember();
            User to = request.getToMember();
            from.addConnection(to);
            to.addConnection(from);
            System.out.printf("%s accepted the connection request from %s.%n", to.getName(), from.getName());
            connectionRequests.remove(requestId);
        }
        else{
            System.out.println("Invalid or already handled request ID.");
        }
    }

}
