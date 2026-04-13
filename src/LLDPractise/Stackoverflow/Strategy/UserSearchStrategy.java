package LLDPractise.Stackoverflow.Strategy;

import LLDPractise.Stackoverflow.Entities.Question;
import LLDPractise.Stackoverflow.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserSearchStrategy implements SearchStrategy{

    private final User user;
    public UserSearchStrategy(User user){
        this.user = user;
    }

    @Override
    public List<Question> filter(List<Question> questions){
        List<Question> res = new ArrayList<>();
        for(Question q : questions){
            if(q.getAuthor().getId().equals(user.getId())){
                res.add(q);
            }
        }
        return res;
    }

}
