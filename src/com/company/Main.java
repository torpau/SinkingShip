package com.company;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main(){
        GameProgress gameProgress = new GameProgress();
        if(gameProgress.ifGameIsSaved()) { fetchSavedGameData(); }
        GameBoard gameBoard = new GameBoard(gameProgress);

    }


    public static void main(String[] args) {
       new Main();
    }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
