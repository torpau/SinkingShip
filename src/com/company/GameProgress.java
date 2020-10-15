package com.company;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class GameProgress {
    private static String pushedButton = "";

    public GameProgress() {

    }
    //public static void setPushedButton(String pushedButton) { pushedButton = pushedButton; }
    //public static String getPushedButton() { return pushedButton; }

    static void initGameStart() {
        userDialogueCarrier();

    }

    static void userDialogueCarrier() {
        String placeHolder = "Carrier";
        JOptionPane pane = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(pane, "Place your Carrier\n Vertically or horizontally only\n Size: 5 squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
            quitGame(placeHolder);
        } else {
            Carrier carrier = new Carrier();
            placeShip(carrier, placeHolder);
        }
    }

    static void quitGame(String placeHolder) {
        JOptionPane quitGame = new JOptionPane();
        Object[] options = {"Yes, quit and save", "No, continue playing"};
        int choice = JOptionPane.showOptionDialog(quitGame, "Do you want to exit the game", "Quit game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (choice == 0) {
            saveGame(placeHolder);
        } else {
            if(placeHolder.equals("Carrier")){ userDialogueCarrier(); }
        }

    }

    static void saveGame(String placeHolder) {
        if(placeHolder.equals("Carrier")){
            JOptionPane noGame = new JOptionPane();
            JOptionPane.showMessageDialog(noGame,"There is no game to save!", "No game", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else{
            //här ska vi spara ner data till fil.
        }

    }

    static boolean ifGameIsSaved() {
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


    static void placeShip(Ship currentShip , String placeHolder) {
        if(pushedButton.equals("")){
            pushedButton(currentShip, placeHolder);
        }
        else{
            int[] pos = currentShip.getPosition();

            for(int i = 0; i < currentShip.getShipLength(); i++){
                if(Integer.parseInt(pushedButton.substring(6))==pos[i]){
                    currentShip.setPosition(i, 0);
                    pushedButton = "";
                    break;
                }
            }
            if(!pushedButton.equals("")) {
                currentShip.setPosition(Integer.parseInt(pushedButton.substring(6)));
            }
            System.out.println(pos[0]);
            System.out.println(pos[1]);
            System.out.println(pos[2]);
            System.out.println(pos[3]);
            System.out.println(pos[4]);


        }
    }



    static void pushedButton(Ship currentShip, String placeHolder){
        pushedButton = "";
        GameBoard.rightB[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameProgress.pushedButton = e.getActionCommand();
                placeShip(currentShip, placeHolder);
            }

        });
        GameBoard.rightB[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameProgress.pushedButton = e.getActionCommand();
                placeShip(currentShip, placeHolder);
            }

        });
        GameBoard.rightB[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameProgress.pushedButton = e.getActionCommand();
                placeShip(currentShip, placeHolder);
            }

        });
    }

}