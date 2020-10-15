package com.company;

public class BattleShip implements Ship {
    private final int shipLength = 4;
    private int[] position = {0,0,0,0};

    public BattleShip() {

    }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index, int value) {}
    public void setPosition(int index) {}

    public int[] getPosition() { return position; }
}

