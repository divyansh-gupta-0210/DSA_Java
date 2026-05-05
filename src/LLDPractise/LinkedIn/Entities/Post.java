package LLDPractise.LinkedIn.Entities;

import LLDPractise.LinkedIn.Enums.NotificationType;
import LLDPractise.LinkedIn.Observer.Subject;

import java.time.LocalDateTime;
import java.util.*;

public class Post extends Subject {

    private final String id;
    private final User author;
    private final String content;
    private final LocalDateTime createdAt;
    private final List<Like> likes = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public Post(User user, String content){
        this.author = user;
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.addObserver(author);
    }

    public void addLike(User user){
        likes.add(new Like(user));
        String notificationContent = user.getName() + " liked your post: ";
        Notification notification = new Notification(author.getId(), NotificationType.POST_LIKE, notificationContent);
        notifyObservers(notification);
    }

    public void addComment(User user, String text) {
        comments.add(new Comment(user, text));
        String notificationContent = user.getName() + " commented on your post: \"" + text + "\"";
        Notification notification = new Notification(author.getId(), NotificationType.POST_COMMENT, notificationContent);
        notifyObservers(notification);
    }

    public String getId() { return id; }
    public User getAuthor() { return author; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<Like> getLikes() { return likes; }
    public List<Comment> getComments() { return comments; }

}
