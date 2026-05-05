package LLDPractise.LinkedIn.Strategy;

import LLDPractise.LinkedIn.Entities.Post;

import java.util.List;

public interface FeedSortingStrategy {
    List<Post> sort(List<Post> posts);
}
