package com.company;

public class Destroyer implements Ship {
    private final String shipType = "Destroyer";
    private final int shipLength = 2;
    private int[] position = {0,0};

    public Destroyer() {

    }

    public String getShipType(){ return this.shipType; }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index, int value) {}
    public void setPosition(int index) {}

    public int[] getPosition() { return position; }
}



