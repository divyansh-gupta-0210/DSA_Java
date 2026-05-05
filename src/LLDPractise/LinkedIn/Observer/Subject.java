package LLDPractise.LinkedIn.Observer;

import LLDPractise.LinkedIn.Entities.Notification;

import java.util.*;

public class Subject {

    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer){
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(Notification notification){
        for(NotificationObserver observer : observers){
            observer.update(notification);
        }
    }

}
