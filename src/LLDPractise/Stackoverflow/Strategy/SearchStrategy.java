package LLDPractise.Stackoverflow.Strategy;

import LLDPractise.Stackoverflow.Entities.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
