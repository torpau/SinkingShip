package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class GameProgress extends GameBoard{
    private String pushedButton = "";
    private Ship currentShip;
    private GameBoard gameBoardTemp;
    private Color[] colors = new Color[10];
    private boolean yourTurn = true;

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoardTemp = gameBoard;
    }

    public void setColors() {
        for(int i = 1; i < colors.length+1; i++ ) {
            this.colors[i-1] = new Color(180-(15*i));
        }
    }
    public Color getColor(int i) { return this.colors[i];}

    public void setPushedButton(String value){ this.pushedButton = value; }
    //public String getPushedButton() { return this.pushedButton; }


    //public void setCurrentShip(Ship value){ this.currentShip = value; }
    public Ship getCurrentShip() { return this.currentShip; }

    public GameProgress() {
    }


    void initGameStart(GameBoard gameBoard) {
        Carrier carrier = new Carrier();
        currentShip = carrier;
        userDialogueShip(gameBoard, carrier);
    }

    void userDialogueShip(GameBoard gameBoard, Ship currentShip) {
        gameBoardTemp = null;
        JOptionPane pane = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(pane, "Place your " + getCurrentShip().getShipType() + "\n Vertically or horizontally only\n Size: " + getCurrentShip().getShipLength() + " squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
            quitGame(currentShip, gameBoard);
        } else {
            placeShip(currentShip);
        }
    }

    void quitGame(Ship currentShip, GameBoard gameBoard) {
        JOptionPane quitGame = new JOptionPane();
        Object[] options = {"Yes, quit and save", "No, continue playing"};
        int choice = JOptionPane.showOptionDialog(quitGame, "Do you want to exit the game", "Quit game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (choice == 0) {
            saveGame(getCurrentShip().getShipType());
        } else {
            if(getCurrentShip().getShipType().equals("Carrier")){ userDialogueShip(gameBoard, getCurrentShip()); }
        }
    }
    void quitGame(String placeHolder) {
        JOptionPane quitGame = new JOptionPane();
        Object[] options = {"Yes, quit and save", "No, continue playing"};
        int choice = JOptionPane.showOptionDialog(quitGame, "Do you want to exit the game", "Quit game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (choice == 0) {
            saveGame(placeHolder);
        }
    }

    void saveGame(String placeHolder) {
        if(placeHolder.equals("Carrier")){
            JOptionPane noGame = new JOptionPane();
            JOptionPane.showMessageDialog(noGame,"There is no game to save!", "No game", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else{


            if(getCurrentShip().getShipType()=="Carrier"){
                for(int i = 0; i < getCurrentShip().getShipLength(); i++) {
                    if(getCurrentShip().getPosition()[i] == 0) {
                        break;
                    }
                }
            }




            //här ska vi spara ner data till fil.
            System.exit(0);
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


    void placeShip(Ship currentShip) {
        if(!pushedButton.equals("")){ //om en knapp är tryckt
            int[] pos = currentShip.getPosition();
            for(int i = 0; i < currentShip.getShipLength(); i++){
                if(Integer.parseInt(pushedButton.substring(6))==pos[i]){
                    currentShip.setPosition(i, 0);
                    rightB[Integer.parseInt(pushedButton.substring(6))].setBackground(getColor(whichRowColor(Integer.parseInt(pushedButton.substring(6)))));
                    pushedButton = "";
                    break;
                }
            }
            if(!pushedButton.equals("")){
                currentShip.setPosition(Integer.parseInt(pushedButton.substring(6)));
                gameBoardTemp.rightB[Integer.parseInt(pushedButton.substring(6))].setBackground(getShipFloating());
            }
            System.out.println(pos[0]);
            System.out.println(pos[1]);
            System.out.println(pos[2]);
            System.out.println(pos[3]);
            System.out.println(pos[4]);

            for(int i = 0; i < 5; i++){
                if(pos[i]!=0){

                    //userDialogueShip(gameBoardTemp, getCurrentShip());
                }
            }
        }
    }

    void setTurn() {
        JLabel turnLabel = new JLabel("Opponents turn");
        Font font = new Font("Verdana", Font.BOLD, 46);
        turnLabel.setFont(font);
        turnLabel.setBackground(new Color(128, 222, 173));
        turnLabel.setVisible(true);
        turnLabel.setHorizontalAlignment(JLabel.CENTER);
        turnLabel.setVerticalAlignment(JLabel.CENTER);
        turnLabel.setBounds(0, 0, 200, 100);
        //turnLabel.setComponentZOrder(JLabel.TOP, 1);


            if (yourTurn) {
                yourTurn = false;
                f.add(turnLabel);
                turnLabel.validate();
                turnLabel.repaint();
            } else {
                yourTurn = true;
                f.remove(turnLabel);
            }
    }

    boolean getTurn () { return yourTurn; }


    public void afterActionCommand(){ pushedButton = ""; }

    public void testArray(){

        int[][] rightGrid = new int[101][2];


        System.out.println( "test"+rightGrid[3][0]);

    }



}