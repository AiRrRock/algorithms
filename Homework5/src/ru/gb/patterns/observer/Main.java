package ru.gb.patterns.observer;

public class Main {
    public static void main(String[] args) {
        SimpleObservableImpl obj = new SimpleObservableImpl();
        SimpleObserverImpl observer = new SimpleObserverImpl();
        obj.attach(observer);
        obj.setOn(true);
    }
}
