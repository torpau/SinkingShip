package com.company;

public class Carrier implements Ship {
    private int shipLength = 5;
    private int[] position = {0, 0, 0, 0, 0};

    public Carrier() {

    }

    public int getShipLength() { return shipLength; }

    public void setPosition(int index, int value) {
        if(value==0){
            position[index] = 0;
        }
    }

    public void setPosition(int index) {
        for(int i = 0; i < position.length; i++) {
            if(position[i] == 0) {
                position[i] = index;
                break;
            }
        }
    }


    public int[] getPosition() { return position; }
}
