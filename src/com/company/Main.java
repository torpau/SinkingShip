package com.company;



public class Main {

    public static void main(String[] args) {
        if(GameProgress.ifGameIsSaved()) { fetchSavedGameData(); }
        GameBoard.initGameBoard();
    }


    public static void fetchSavedGameData(){
        //läsa in filen och sätta en lista med split.
    }
}
