package com.company;

import java.io.File;
import java.util.Scanner;

public class GameProgress {
    public GameProgress() {

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