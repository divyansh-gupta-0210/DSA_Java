package LLDPractise.LinkedIn.Entities;

import java.time.LocalDateTime;

public class Comment {

    private final User author;
    private final String text;
    private final LocalDateTime createdAt;


    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
