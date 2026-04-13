package LLDPractise.Stackoverflow.Entities;

import LLDPractise.Stackoverflow.Observer.PostObserver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Post extends Content{

    private final AtomicInteger voteCount = new AtomicInteger(0);
    private final Map<String, VoteType> voters = new ConcurrentHashMap<>();
    private final List<Comment> comments = new CopyOnWriteArrayList<>();
    private final List<PostObserver> observerList = new CopyOnWriteArrayList<>();

    public Post(String id, String body, User author){
        super(id, body, author);
    }

    public void addObserver(PostObserver observer){
        this.observerList.add(observer);
    }

    void notifyObservers(Event event){
        observerList.forEach(o -> o.onPostEvent(event));
    }

    public synchronized void vote(User user, VoteType voteType){
        String userId = user.getId();
        if(voters.get(userId) == voteType){
            return;
        }

        int scoreChanged = 0;
        if(voters.containsKey(userId)){
            scoreChanged = (voteType == VoteType.UPVOTE) ? 2 : -2;
        }
        else{
            scoreChanged = (voteType == VoteType.UPVOTE) ? 1 : -1;
        }

        voters.put(userId, voteType);
        voteCount.addAndGet(scoreChanged);
        EventType eventType = EventType.UPVOTE_QUESTION;

        if(this instanceof Question){
            eventType = (voteType == VoteType.UPVOTE) ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        }
        else{
            eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER);
        }
        notifyObservers(new Event(eventType, user, this));
    }

}
