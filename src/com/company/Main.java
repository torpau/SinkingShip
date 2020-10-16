package com.company;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main(){
        GameProgress gameProgress = new GameProgress();
        GameBoard gameBoard = new GameBoard(gameProgress);
        gameProgress.initGameStart();
        if(gameProgress.ifGameIsSaved()) { fetchSavedGameData(); }


    }


    public static void main(String[] args) {
       new Main();
    }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
