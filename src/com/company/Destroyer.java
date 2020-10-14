package com.company;

public class Destroyer implements Ship {
    private final int shipLength = 2;
    private int[] position = {0,0};

    public Destroyer() {

    }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index) {}

    public int[] getPosition() { return position; }
}



