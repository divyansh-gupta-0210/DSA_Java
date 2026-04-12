package LLDPractise.MeetingSchedular.Entites;

public class User {
    public String name;
    public String id;
    public Role role;

    public User(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public int getRolePriority() {
        return role.priority;
    }

    public String getName() {
        return name;
    }

}
