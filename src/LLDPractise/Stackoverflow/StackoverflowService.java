package LLDPractise.Stackoverflow;

import LLDPractise.Stackoverflow.Entities.*;
import LLDPractise.Stackoverflow.Observer.PostObserver;
import LLDPractise.Stackoverflow.Observer.ReputationManager;
import LLDPractise.Stackoverflow.Strategy.SearchStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StackoverflowService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Question> questions = new ConcurrentHashMap<>();
    private final Map<String, Answer> answers = new ConcurrentHashMap<>();
    private final PostObserver reputationManager = new ReputationManager();

    public User createUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String userId, String title, String body, Set<Tag> tags){
        User author = users.get(userId);
        Question question = new Question(title, body, author, tags);
        question.addObserver(reputationManager);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String questionId, String body){
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(body, author);
        answer.addObserver(reputationManager);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Post findPostById(String postId){
        if(questions.containsKey(postId)){
            return questions.get(postId);
        }
        else if(answers.containsKey(postId)){
            return answers.get(postId);
        }
        throw new NoSuchElementException("Post not found");
    }

    public void voteOnPost(String userId, String postId, VoteType voteType){
        User user = users.get(userId);
        Post post = findPostById(postId);
        post.vote(user, voteType);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void acceptAnswer(String questionId, String answerId){
        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);
        question.acceptAnswer(answer);
    }

    public List<Question> searchQuestions(List<SearchStrategy> strategies){
        List<Question> results = new ArrayList<>(questions.values());
        for(SearchStrategy strategy : strategies){
            results = strategy.filter(results);
        }
        return results;
    }

}
