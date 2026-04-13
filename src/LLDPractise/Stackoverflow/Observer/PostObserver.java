package LLDPractise.Stackoverflow.Observer;

import LLDPractise.Stackoverflow.Entities.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}
