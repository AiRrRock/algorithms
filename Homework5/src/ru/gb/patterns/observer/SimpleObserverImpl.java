package ru.gb.patterns.observer;

public class SimpleObserverImpl implements SimpleObserver{
    @Override
    public void update(SimpleObservable observable, Object args) {
        System.out.println("something something ..." + args);
    }
}
