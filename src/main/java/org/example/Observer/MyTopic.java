package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject{
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();
    private List<Observer> observers = new ArrayList<>();

    public MyTopic() {

    }

    @Override
    public void register(Observer observer) {
        observer.setSubject(this);
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String message){
        this.message = message;
        changed = true;
        notifyObservers();
    }
}
