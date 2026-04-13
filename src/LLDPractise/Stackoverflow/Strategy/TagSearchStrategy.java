package LLDPractise.Stackoverflow.Strategy;

import LLDPractise.Stackoverflow.Entities.Question;
import LLDPractise.Stackoverflow.Entities.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagSearchStrategy implements SearchStrategy {

    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        List<Question> res = new ArrayList<>();
        for(Question q : questions){
            for(Tag t : q.getTags()){
                if(t.getName().equalsIgnoreCase(tag.getName())){
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}
