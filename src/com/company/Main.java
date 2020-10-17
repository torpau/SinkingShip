package com.company;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main(){
        GameProgress gameProgress = new GameProgress();
        GameBoard gameBoard = new GameBoard();

        gameBoard.initGameBoard(gameProgress);

        gameProgress.initGameStart(gameBoard);

        if(gameProgress.ifGameIsSaved()) { fetchSavedGameData(); }


    }


    public static void main(String[] args) {

       new Main();

        int[][] rightGrid = new int[101][2];


        System.out.println( "test"+rightGrid[3][0]);
    }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
