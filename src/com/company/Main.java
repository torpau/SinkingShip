package com.company;


import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) {
        if(GameProgress.ifGameIsSaved()) { fetchSavedGameData(); }
        GameBoard.initGameBoard();
        GameProgress.initGameStart();

            }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
