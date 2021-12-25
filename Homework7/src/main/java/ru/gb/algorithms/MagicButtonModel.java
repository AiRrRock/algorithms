package ru.gb.algorithms;

import lombok.Data;

@Data
public class MagicButtonModel {
    private final String magicMessage;
    private int timesClicked;
    private boolean magicTime;

    public MagicButtonModel(String magicMessage) {
        this.magicMessage = magicMessage;
        this.timesClicked = 0;
        this.magicTime = false;
    }

}
