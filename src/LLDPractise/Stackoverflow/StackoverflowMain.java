package LLDPractise.Stackoverflow;

import LLDPractise.Stackoverflow.Entities.*;
import LLDPractise.Stackoverflow.Entities.Tag;
import LLDPractise.Stackoverflow.Entities.User;
import LLDPractise.Stackoverflow.Strategy.*;

import java.util.*;

public class StackoverflowMain {
    public static void main(String[] args) {
        StackoverflowService service = new StackoverflowService();

        User alice = service.createUser("Alice");
        User bob = service.createUser("Bob");
        User charlie = service.createUser("Charlie");

        System.out.println("--- Alice posts a question ---");
        Tag javaTag = new Tag("java");
        Tag designPatternsTag = new Tag("design-patterns");
        Set<Tag> tags = Set.of(javaTag, designPatternsTag);
        Question question = service.postQuestion(alice.getId(), "How to implement Observer Pattern?", "Details about Observer Pattern...", tags);
        printReputations(alice, bob, charlie);

        System.out.println("\n--- Bob and Charlie post answers ---");
        Answer bobAnswer = service.postAnswer(bob.getId(), question.getId(), "You can use the java.util.Observer interface.");
        Answer charlieAnswer = service.postAnswer(charlie.getId(), question.getId(), "A better way is to create your own Observer interface.");
        printReputations(alice, bob, charlie);

        System.out.println("\n--- Voting Occurs ---");
        service.voteOnPost(alice.getId(), question.getId(), VoteType.UPVOTE);
        service.voteOnPost(bob.getId(), charlieAnswer.getId(), VoteType.UPVOTE);
        service.voteOnPost(alice.getId(), bobAnswer.getId(), VoteType.DOWNVOTE);
        printReputations(alice, bob, charlie);

        System.out.println("\n--- Alice accepts Charlie's answer ---");
        service.acceptAnswer(question.getId(), charlieAnswer.getId());
        printReputations(alice, bob, charlie);

        System.out.println("\n--- (C) Combined Search: Questions by 'Alice' with tag 'java' ---");
        List<SearchStrategy> filtersC = List.of(
                new UserSearchStrategy(alice),
                new TagSearchStrategy(javaTag)
        );
        List<Question> searchResults = service.searchQuestions(filtersC);
        searchResults.forEach(q -> System.out.println("  - Found: " + q.getTitle()));
    }

    private static void printReputations(User... users) {
        System.out.println("--- Current Reputations ---");
        for(User user : users) {
            System.out.printf("%s: %d\n", user.getName(), user.getReputation());
        }
    }
}
