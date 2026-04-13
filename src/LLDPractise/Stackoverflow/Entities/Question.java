package LLDPractise.Stackoverflow.Entities;

import java.util.*;
import java.util.UUID;

public class Question extends Post{
    private final String title;
    private final Set<Tag> tags;
    private final List<Answer> answerList = new ArrayList<>();
    private Answer acceptedAnswer;

    public Question(String title, String body, User author, Set<Tag> tag){
        super(UUID.randomUUID().toString(), body, author);
        this.title = title;
        this.tags = tag;
    }

    public void addAnswer(Answer answer){
        this.answerList.add(answer);
    }

    public synchronized void acceptAnswer(Answer answer) {
        if (!this.author.getId().equals(answer.getAuthor().getId()) && this.acceptedAnswer == null) {
            this.acceptedAnswer = answer;
            answer.setAccepted(true);
            notifyObservers(new Event(EventType.ACCEPT_ANSWER, answer.getAuthor(), answer));
        }
    }

    public String getTitle() { return title; }
    public Set<Tag> getTags() { return tags; }
    public List<Answer> getAnswers() { return answerList; }

}
