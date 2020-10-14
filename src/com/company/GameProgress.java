package com.company;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class GameProgress {
    public GameProgress() {
    }

    static void initGameStart() {
        userDialogueCarrier();

    }

    static void userDialogueCarrier() {
        JOptionPane cruiser = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(cruiser, "Place your Carrier\n Vertically or horizontally only\n Size: 5 squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);
        if(choice == 2) {
            quitGame(userDialogueCarrier());
        }
    }

    static void quitGame(Method metod) {
        JOptionPane quitGame = new JOptionPane();
        Object[] options ={"Yes, quit and save", "No, continue playing"};
        int choice = JOptionPane.showOptionDialog(quitGame, "Do you want to exit the game", "Quit game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if(choice == 0) {
            saveGame();
        } else {
            metod
        }

    }

    static void saveGame() {



    }

    static boolean ifGameIsSaved() {
        Scanner sc = null;
        File file = new File("progData/savedGame.txt");
        if (file.exists()) {
            try {
                sc = new Scanner(file);
                return sc.hasNext();
            } catch(Exception e) {
                return false;
            } finally {
                sc.close();
            }
        }
        return false;
    }
}