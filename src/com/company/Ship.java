package com.company;

public interface Ship {
    String getShipType();
    int getShipLength();
    void setPosition(int index, int value);
    void setPosition(int index);
    int[] getPosition();

}
