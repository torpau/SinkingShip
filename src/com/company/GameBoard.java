package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameBoard {
    public static JFrame f = new JFrame();
    private static final int frameWidth = 1110;
    private static final int frameHeight = 560;
    public static JButton[] leftB = new JButton[101];
    public static JButton[] rightB = new JButton[101];
    private static final Font font = new Font("Verdana", Font.PLAIN, 12);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public GameBoard() {

    }

    static void initGameBoard() {
        //GameBoard.f.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        f.setBounds(200, 150, frameWidth, frameHeight);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);

        printLeftGridTopLabels();
        printLeftGridSideLabels();
        printLeftGridButtons();
        printMidLine();
        printRightGridTopLabels();
        printRightGridSideLabels();
        printRightGridButtons();

    }

    static void printLeftGridTopLabels() {
        int width = 79;
        JLabel[] leftTL = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            leftTL[i] = new JLabel(Character.toString((char) 65 + i));
            leftTL[i].setBounds(width, 35, 44, 44);
            leftTL[i].setBorder(blackline);
            leftTL[i].setHorizontalAlignment(JLabel.CENTER);
            leftTL[i].setVerticalAlignment(JLabel.CENTER);
            leftTL[i].setFont(font);
            f.add(leftTL[i]);
            width = width + 44;
        }
    }

    static void printLeftGridSideLabels() {
        int width = 35;
        int height = 79;
        JLabel[] leftSL = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            leftSL[i] = new JLabel("" + (i+1));
            leftSL[i].setBounds(width, height, 44, 44);
            leftSL[i].setBorder(blackline);
            leftSL[i].setHorizontalAlignment(JLabel.CENTER);
            leftSL[i].setVerticalAlignment(JLabel.CENTER);
            leftSL[i].setFont(font);
            f.add(leftSL[i]);
            height = height + 44;
        }
    }

    static void printLeftGridButtons() {
        int width = 79;
        int height = 79;

        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                leftB[i*j] = new JButton();
                leftB[i*j].setBounds(width,height,44, 44);
                leftB[i*j].setEnabled(true);
                leftB[i*j].setText("X");
                f.add(leftB[i*j]);
                width = width + 44;
            }
            width = 79;
            height = height + 44;
        }
    }

    static void printMidLine() {
        JLabel midLine = new JLabel();
        midLine.setBounds(frameWidth/2, 0, 1, frameHeight);
        midLine.setBorder(blackline);
        f.add(midLine);
    }

    static void printRightGridTopLabels() {
        int width = (frameWidth/2) + 79;
        JLabel[] rightTL = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            rightTL[i] = new JLabel(Character.toString((char) 65 + i));
            rightTL[i].setBounds(width, 35, 44, 44);
            rightTL[i].setBorder(blackline);
            rightTL[i].setHorizontalAlignment(JLabel.CENTER);
            rightTL[i].setVerticalAlignment(JLabel.CENTER);
            rightTL[i].setFont(font);
            f.add(rightTL[i]);
            width = width + 44;
        }
    }

    static void printRightGridSideLabels() {
        int width = (frameWidth/2) + 35;
        int height = 79;
        JLabel[] rightSL = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            rightSL[i] = new JLabel("" + (i+1));
            rightSL[i].setBounds(width, height, 44, 44);
            rightSL[i].setBorder(blackline);
            rightSL[i].setHorizontalAlignment(JLabel.CENTER);
            rightSL[i].setVerticalAlignment(JLabel.CENTER);
            rightSL[i].setFont(font);
            f.add(rightSL[i]);
            height = height + 44;
        }
    }

    static void printRightGridButtons() {
        int width = (frameWidth/2) + 79;
        int height = 79;

        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                rightB[i*j] = new JButton();
                rightB[i*j].setBounds(width,height,44, 44);
                rightB[i*j].setEnabled(true);
                rightB[i*j].setText("X");
                f.add(rightB[i*j]);
                width = width + 44;
            }
            width = (frameWidth/2) + 79;
            height = height + 44;
        }
    }

}



