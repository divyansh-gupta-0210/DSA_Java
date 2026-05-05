package LLDPractise.LinkedIn.Entities;

import java.time.LocalDateTime;

public class Like {
    private final User user;
    private final LocalDateTime createdAt;

    public Like(User user){
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public User getUser(){
        return user;
    }

}
