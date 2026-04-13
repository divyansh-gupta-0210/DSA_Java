package LLDPractise.Stackoverflow.Entities;

import java.util.UUID;

public class Comment extends Content{

    public Comment(String body, User author){
        super(UUID.randomUUID().toString(), body, author);
    }

}
