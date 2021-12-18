package ru.gb.patterns.observer;

public interface SimpleObserver {
    void update(SimpleObservable observable, Object args);
}
