package LLDPractise.LinkedIn.Entities;

import LLDPractise.LinkedIn.Observer.NotificationObserver;

import java.util.*;

public class User implements NotificationObserver {

    private final String id;
    private final String name;
    private final String email;
    private final Profile profile;
    private final Set<User> connections = new HashSet<>();
    private final List<Notification> notifications = new ArrayList<>();

    private User(String id, String name, String email, Profile profile){
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
    }

    public void addConnection(User user){
        connections.add(user);
    }

    public void displayProfile(){
        System.out.println("\n--- Profile for " + name + " (" + email + ") ---");
        profile.display();
        System.out.println("Connection size " + connections.size());
    }

    public void viewNotifications(){
        System.out.println("\n--- Notifications for " + name + " ---");
        if(notifications.isEmpty()){
            System.out.println("No new notifications");
            return;
        }
        for(Notification n : notifications){
            if(!n.isRead()){
                System.out.println(" - " + n.getContent());
                n.markAsRead();
            }
        }
    }

    public void update(Notification notification){
        this.notifications.add(notification);
        System.out.printf("Notification pushed to %s: %s%n", this.name, notification.getContent());
    }

    public String getId() {
        return id;
    }

    public Set<User> getConnections() {
        return connections;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static class Builder{
        private final String id;
        private final String name;
        private final String email;
        private final Profile profile = new Profile();

        public Builder(String name, String email) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.email = email;
        }

        public Builder withSummary(String summary) {
            this.profile.setSummary(summary);
            return this;
        }

        public Builder addExperience(Experience experience) {
            this.profile.addExperience(experience);
            return this;
        }

        public Builder addEducation(Education education) {
            this.profile.addEducation(education);
            return this;
        }

        public User build() {
            return new User(id, name, email, profile);
        }
    }
}
