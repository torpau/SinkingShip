package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class GameProgress {
    public GameProgress() {
    }

    static void initGameStart() {
        userDialogueCarrier();

    }

    static void userDialogueCarrier() {
        String placeHolder = "Carrier";
        JOptionPane cruiser = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(cruiser, "Place your Carrier\n Vertically or horizontally only\n Size: 5 squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
            quitGame(placeHolder);
        } else {
            placeShip(placeHolder);
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


    static void placeShip(String placeHolder) {

        GameBoard.rightB[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pushed");
            }
        });

    }
}