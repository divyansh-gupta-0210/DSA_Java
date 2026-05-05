package LLDPractise.LinkedIn.Services;

import LLDPractise.LinkedIn.Entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchService {
    private final Collection<User> users;

    public SearchService(Collection<User> users){
        this.users = users;
    }

    public List<User> searchByName(String name){
        List<User> result = new ArrayList<>();
        for(User user : users){
            if(user.getName().toLowerCase().contains(name)){
                result.add(user);
            }
        }
        return result;
    }

}
