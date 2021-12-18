package ru.gb.patterns.observer;

public class SimpleObservableImpl extends  SimpleObservable{
    private boolean isOn;

    public void setOn(boolean on) {
        isOn = on;
        notify(isOn);
    }
}
