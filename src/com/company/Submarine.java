package com.company;

public class Submarine implements Ship {
    private final int shipLength = 3;
    private int[] position = {0,0,0};

    public Submarine() {

    }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index) {}

    public int[] getPosition() { return position; }
}

