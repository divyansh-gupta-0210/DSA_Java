package LLDPractise.Stackoverflow.Strategy;

import LLDPractise.Stackoverflow.Entities.Question;

import java.util.ArrayList;
import java.util.List;

public class KeywordSearchStrategy implements SearchStrategy {

    private final String keyword;

    public KeywordSearchStrategy(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        List<Question> result = new ArrayList<>();
        for(Question q : questions){
            String title = q.getTitle().toLowerCase();
            String body = q.getBody().toLowerCase();
            if(title.contains(keyword) || body.contains(keyword)){
                result.add(q);
            }
        }
        return result;
    }

}