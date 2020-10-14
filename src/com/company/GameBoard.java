package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.Component.CENTER_ALIGNMENT;

public class GameBoard {
    public static JFrame f = new JFrame();
    private static final int frameWidth = 1110;
    private static final int frameHeight = 560;
    public static JButton[] leftB = new JButton[101];
    public static JButton[] rightB = new JButton[101];
    private static final Font font = new Font("Verdana", Font.PLAIN, 12);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);
    private static final Color shipFloating = new Color(45, 149, 63, 255);
    private static final Color shipSunk = new Color(179, 11, 11);


    public GameBoard() {

    }

    static void initGameBoard() {
        //GameBoard.f.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        f.setBounds(200, 150, frameWidth, frameHeight);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);

        printLeftGridHeadLabel();
        printLeftGridTopLabels();  //vår planhalva
        printLeftGridSideLabels();
        printLeftGridButtons();
        printMidLine();
        printRightGridHeadLabel();
        printRightGridTopLabels(); //motståndarens
        printRightGridSideLabels();
        printRightGridButtons();
        userDialogueFrameCruiser();

    }

    static void userDialogueFrameCruiser() {
        //JFrame u = new JFrame();
        //u.setBounds(frameWidth/2, frameHeight/2, 350, 250);
        //u.setVisible(true);
        //u.setAlwaysOnTop(true);

        JOptionPane cruiser = new JOptionPane();
        int choice = JOptionPane.showConfirmDialog(cruiser, "Place your Cruiser\n Vertically or horizontally only\n Size: 5 squares", "Place Battleships", JOptionPane.OK_CANCEL_OPTION);


    }

    static void changeToImageWhenHit() {

    }

    static void printLeftGridHeadLabel() {
        JLabel leftHL = new JLabel("Your field");
        leftHL.setBounds((frameWidth/4)-40, 5, 150, 16);
        leftHL.setFont(new Font("Verdana", Font.BOLD, 14));
        f.add(leftHL);
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
                leftB[i*j] = new JButton(new ImageIcon("progData/images/hit3.png"));
                leftB[i*j].setBounds(width,height,44, 44);
                leftB[i*j].setEnabled(true);
                leftB[i*j].setBackground(new Color(0, 0, 180-(15*i)));
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

    static void printRightGridHeadLabel() {
        JLabel rightHL = new JLabel("Opponents field");
        rightHL.setBounds((frameWidth/4)*3-54, 5, 150, 18);
        rightHL.setFont(new Font("Verdana", Font.BOLD, 14));

        f.add(rightHL);
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
                rightB[i*j].setText("");
                rightB[i*j].setBackground(new Color(0, 0, 180-(15*i)));
                f.add(rightB[i*j]);
                width = width + 44;

            }
            width = (frameWidth/2) + 79;
            height = height + 44;
        }
    }

}



