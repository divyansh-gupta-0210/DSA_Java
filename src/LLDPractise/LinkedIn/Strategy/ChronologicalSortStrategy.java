package LLDPractise.LinkedIn.Strategy;

import LLDPractise.LinkedIn.Entities.Post;

import java.util.*;

public class ChronologicalSortStrategy implements FeedSortingStrategy {

    @Override
    public List<Post> sort(List<Post> posts) {
        List<Post> result = new ArrayList<>();
        posts.sort(Comparator.comparing(Post::getCreatedAt).reversed());
        for(Post post : posts){
            result.add(post);
        }
        return result;
    }
}
