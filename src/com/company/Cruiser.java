package com.company;

public class Cruiser implements Ship {
    private final String shipType = "Cruiser";
    private final int shipLength = 3;
    private int[] position = {0,0,0};

    public Cruiser() {

    }

    public String getShipType(){ return this.shipType; }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index, int value) {}
    public void setPosition(int index) {}

    public int[] getPosition() { return position; }
}

