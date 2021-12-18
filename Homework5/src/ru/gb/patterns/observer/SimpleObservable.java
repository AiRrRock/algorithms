package ru.gb.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleObservable {
    private List<SimpleObserver> observers = new ArrayList<>();

    public void attach(SimpleObserver observer){
        observers.add(observer);
    }

    public void detach(SimpleObserver observer){
        observers.remove(observer);
    }

    public void notify(Object arg){
        for (SimpleObserver observer: observers) {
            observer.update(this, arg);
        }
    }
}
