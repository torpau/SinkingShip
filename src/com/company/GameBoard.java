package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameBoard {
    public static JFrame f = new JFrame();
    private static final int frameWidth = 720;
    private static final int frameHeight = 400;
    private static final Font font = new Font("Verdana", Font.PLAIN, 12);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public GameBoard() {

    }

    static void initGameBoard() {
        GameBoard.f.setBounds(200, 150, frameWidth, frameHeight);
        GameBoard.f.setLayout(null);//using no layout managers
        GameBoard.f.setVisible(true);//making the frame visible
        //f.getJMenuBar();

        JButton b = new JButton("");//creating instance of JButton
        b.setBounds((frameWidth-58),30,25, 25);//x axis, y axis, width, height
        b.setEnabled(false);




        printMidLine();
        printMainGridTopLabels();
        printMainGridButtons();


    }

    static void printMidLine() {
        JLabel midLine = new JLabel();
        midLine.setBounds(frameWidth/2, 0, 1, frameHeight);
        midLine.setBorder(blackline);
        GameBoard.f.add(midLine);
    }

    static void printMainGridTopLabels() {
        int width = (frameWidth/2) + 35;
        JLabel[] l = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            l[i] = new JLabel(Character.toString((char) 65 + i));
            l[i].setBounds(width, 35, 30, 20);
            l[i].setBorder(blackline);
            l[i].setHorizontalAlignment(JLabel.CENTER);
            l[i].setVerticalAlignment(JLabel.CENTER);
            l[i].setFont(font);
            GameBoard.f.add(l[i]);
            width = width + 30;
        }
    }

   static void printMainGridButtons() {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                JButton b = new JButton("");
                b.setBounds((frameWidth-58),30,25, 25);
                b.setEnabled(false);
                GameBoard.f.add(b);

            }
        }





    }
}



