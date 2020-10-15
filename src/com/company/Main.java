package com.company;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main(){
        GameBoard gameBoard = new GameBoard(new GameProgress());
        GameProgress gameProgress = new GameProgress();
        if(gameProgress.ifGameIsSaved()) { fetchSavedGameData(); }


    }


    public static void main(String[] args) {
       new Main();
    }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
