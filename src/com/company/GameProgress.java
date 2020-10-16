package com.company;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class GameProgress {
    private String pushedButton = "";
    private String placeHolder;
    private Ship currentShip;

    private Color[] colors = new Color[10];

    public void setColors() {
        for(int i = 1; i < colors.length+1; i++ ) {
            this.colors[i-1] = new Color(180-(15*i));
        }
    }
    public Color getColor(int i) { return this.colors[i];}

    public void setPushedButton(String value){ this.pushedButton = value; }
    //public String getPushedButton() { return this.pushedButton; }

    //public void setPlaceHolder(String value){ this.placeHolder = value; }
    public String getPlaceHolder() { return this.placeHolder; }

    //public void setCurrentShip(Ship value){ this.currentShip = value; }
    public Ship getCurrentShip() { return this.currentShip; }

    public GameProgress() {
    }


    void initGameStart(GameBoard gameBoard) {
        userDialogueCarrier(gameBoard);
    }

    void userDialogueCarrier(GameBoard gameBoard) {
        placeHolder = "Carrier";
        JOptionPane pane = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(pane, "Place your Carrier\n Vertically or horizontally only\n Size: 5 squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
            quitGame(placeHolder, gameBoard);
        } else {
            Carrier carrier = new Carrier();
            placeShip(carrier, placeHolder, gameBoard);
        }
    }

    void quitGame(String placeHolder, GameBoard gameBoard) {
        JOptionPane quitGame = new JOptionPane();
        Object[] options = {"Yes, quit and save", "No, continue playing"};
        int choice = JOptionPane.showOptionDialog(quitGame, "Do you want to exit the game", "Quit game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (choice == 0) {
            saveGame(placeHolder);
        } else {
            if(placeHolder.equals("Carrier")){ userDialogueCarrier(gameBoard); }
        }

    }

    void saveGame(String placeHolder) {
        if(placeHolder.equals("Carrier")){
            JOptionPane noGame = new JOptionPane();
            JOptionPane.showMessageDialog(noGame,"There is no game to save!", "No game", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else{
            //här ska vi spara ner data till fil.
        }

    }

    boolean ifGameIsSaved() {
        Scanner sc = null;
        File file = new File("progData/savedGame.txt");
        if (file.exists()) {
            try {
                sc = new Scanner(file);
                return sc.hasNext();
            } catch (Exception e) {
                return false;
            } finally {
                sc.close();
            }
        }
        return false;
    }


    void placeShip(Ship currentShip , String placeHolder, GameBoard gameBoard) {
        if(!pushedButton.equals("")){ //om en knapp är tryckt
            int[] pos = currentShip.getPosition();
            for(int i = 0; i < currentShip.getShipLength(); i++){
                if(Integer.parseInt(pushedButton.substring(6))==pos[i]){
                    currentShip.setPosition(i, 0);
                    gameBoard.rightB[Integer.parseInt(pushedButton.substring(6))].setBackground(getColor(gameBoard.whichRowColor(Integer.parseInt(pushedButton.substring(6)))));
                    pushedButton = "";
                    break;
                }
            }
            if(!pushedButton.equals("")){
                currentShip.setPosition(Integer.parseInt(pushedButton.substring(6)));
                gameBoard.rightB[Integer.parseInt(pushedButton.substring(6))].setBackground(gameBoard.getShipFloating());
            }
            System.out.println(pos[0]);
            System.out.println(pos[1]);
            System.out.println(pos[2]);
            System.out.println(pos[3]);
            System.out.println(pos[4]);
        }
    }


    public void afterActionCommand(){ pushedButton = ""; }


}