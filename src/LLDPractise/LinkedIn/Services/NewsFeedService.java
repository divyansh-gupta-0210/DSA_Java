package LLDPractise.LinkedIn.Services;

import LLDPractise.LinkedIn.Entities.NewsFeed;
import LLDPractise.LinkedIn.Entities.Post;
import LLDPractise.LinkedIn.Entities.User;
import LLDPractise.LinkedIn.Strategy.FeedSortingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewsFeedService {
    private final Map<String, List<Post>> allPosts;

    public NewsFeedService(){
        this.allPosts = new ConcurrentHashMap<>();
    }

    public void addPost(User user, Post post){
        String memberId = user.getId();
        if(!allPosts.containsKey(memberId)){
            allPosts.put(memberId, new ArrayList<>());
        }
        allPosts.get(memberId).add(post);
    }

    public List<Post> getAllPosts(User user){
        return allPosts.getOrDefault(user.getId(), new ArrayList<>());
    }

    public List<Post> getMemberPosts(User member) {
        return allPosts.getOrDefault(member.getId(), new ArrayList<>());
    }

    public void displayFeedForUser(User user, FeedSortingStrategy strategy){
        List<Post> feedPosts = new ArrayList<>();
        for(User connection : user.getConnections()){
            List<Post> connectionPosts = allPosts.get(connection.getId());
            if(connectionPosts != null){
                feedPosts.addAll(connectionPosts);
            }
        }
        NewsFeed feed = new NewsFeed(feedPosts);
        feed.display(strategy);
    }

}
