package LLDPractise.LinkedIn;

import LLDPractise.LinkedIn.Entities.Post;
import LLDPractise.LinkedIn.Entities.User;
import LLDPractise.LinkedIn.Services.*;
import LLDPractise.LinkedIn.Strategy.ChronologicalSortStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedInSystem {
    private static volatile LinkedInSystem instance;
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private final ConnectionService connectionService;
    private final NewsFeedService newsFeedService;
    private final SearchService searchService;

    private LinkedInSystem() {
        this.connectionService = new ConnectionService(new NotificationService());
        this.newsFeedService = new NewsFeedService();
        this.searchService = new SearchService(users.values());
    }

    public static LinkedInSystem getInstance() {
        if (instance == null) {
            synchronized (LinkedInSystem.class) {
                if (instance == null) {
                    instance = new LinkedInSystem();
                }
            }
        }
        return instance;
    }

    public void registerMember(User user) {
        users.put(user.getId(), user);
        System.out.println("New member registered: " + user.getName());
    }

    public User getMember(String name) {
        for(User m : users.values()){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public String sendConnectionRequest(User from, User to) {
        return connectionService.sendRequest(from, to);
    }

    public void acceptConnectionRequest(String requestId) {
        connectionService.acceptRequest(requestId);
    }

    public void createPost(String memberId, String content) {
        User author = users.get(memberId);
        Post post = new Post(author, content);
        newsFeedService.addPost(author, post);
        System.out.printf("%s created a new post.%n", author.getName());
    }

    public Post getLatestPostByMember(String memberId) {
        List<Post> memberPosts = newsFeedService.getMemberPosts(users.get(memberId));
        if (memberPosts == null || memberPosts.isEmpty()) return null;
        return memberPosts.get(memberPosts.size() - 1);
    }

    public void viewNewsFeed(String memberId) {
        User member = users.get(memberId);
        System.out.println("\n--- News Feed for " + member.getName() + " ---");
        newsFeedService.displayFeedForUser(member, new ChronologicalSortStrategy());
    }

    public List<User> searchMemberByName(String name) {
        return searchService.searchByName(name);
    }
}
