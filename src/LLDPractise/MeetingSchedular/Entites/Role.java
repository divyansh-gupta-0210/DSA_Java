package LLDPractise.MeetingSchedular.Entites;

public enum Role {
    NORMAL(1),
    VIP(2),
    VVIP(3);

    int priority;

    Role(int priority) {
        this.priority = priority;
    }
}