package LLDPractise.LinkedIn.Entities;

import LLDPractise.LinkedIn.Enums.ConnectionStatus;

import java.time.LocalDateTime;

public class Connection {

    private final User fromMember;
    private final User toMember;
    private ConnectionStatus status;
    private final LocalDateTime requestedAt;
    private LocalDateTime acceptedAt;

    public Connection(User fromMember, User toMember) {
        this.toMember = toMember;
        this.requestedAt = LocalDateTime.now();
        this.status = ConnectionStatus.PENDING;
        this.fromMember = fromMember;
    }

    public User getFromMember() { return fromMember; }
    public User getToMember() { return toMember; }
    public ConnectionStatus getStatus() { return status; }

    public void setStatus(ConnectionStatus status){
        this.status = status;
        if(status == ConnectionStatus.ACCEPTED){
            this.acceptedAt = LocalDateTime.now();
        }
    }

}
