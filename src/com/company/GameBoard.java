package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.temporal.ValueRange;

public class GameBoard{
    public final JFrame f = new JFrame();
    private final int frameWidth = 1110;
    private final int frameHeight = 591;
    private final Font font = new Font("Verdana", Font.PLAIN, 12);
    private final Border blackline = BorderFactory.createLineBorder(Color.black);
    private final Color shipFloating = new Color(45, 149, 63, 255);
    private final Color shipSunk = new Color(179, 11, 11);
    private final ImageIcon hit = new ImageIcon("progData/images/hit3.png");
    private final ImageIcon noHit = new ImageIcon("progData/images/dropp.png");
    public static final JButton[] leftB = new JButton[101];
    public static final JButton[] rightB = new JButton[101];
    private int[][] leftGridArray = new int[101][2];
    private int[][] rightGridArray = new int[101][2];
    public final Color[] colors = new Color[10];


    public GameBoard() {

    }

    void initGameBoard(GameProgress gameProgress) {
        f.setBounds(200, 150, frameWidth, frameHeight);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        printLeftGridHeadLabel();
        printLeftGridTopLabels();  //vår planhalva
        printLeftGridSideLabels();
        printLeftGridButtons(gameProgress);
        printMidLine();
        printRightGridHeadLabel();
        printRightGridTopLabels(); //motståndarens
        printRightGridSideLabels();
        printRightGridButtons(gameProgress);
        gameProgress.setColors();
        placeOpponentsShipOnRightGrid();

        f.repaint();

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                gameProgress.quitGame("Gameboard");
            }
        });

        gameProgress.setGameBoard(this);
    }

    private void setLeftGridArrayAtIndex(int leftBIndex, int shipOrNot, int value) { leftGridArray[leftBIndex][shipOrNot] = value; }
    private int getLeftGridArrayFromIndex(int leftBIndex, int shipOrNot) { return leftGridArray[leftBIndex][shipOrNot]; }

    private void setRightGridArrayAtIndex(int rightBIndex, int shipOrNot, int value) { rightGridArray[rightBIndex][shipOrNot] = value; }
    private int getRightGridArrayFromIndex(int rightBIndex, int shipOrNot) { return rightGridArray[rightBIndex][shipOrNot]; }


    public Color getShipFloating() { return this.shipFloating; }
    public Color getShipSunk() { return this.shipSunk; }

    //public JButton getRightB(int index) { return rightB[index]; }
    //public void setRightB(JButton b, int index) { this.rightB[index] = b; }

    public int whichRowColor(int index) {
        if((index%10)==0){
            return (index/10) - 1;
        }
        else {
            return ((int)(Math.round((index/10)+0.5)) *10)/10 - 1;
        }
    }

    static void changeToImageWhenHit() {}



    void printLeftGridHeadLabel() {
        JLabel leftHL = new JLabel("Your field");
        leftHL.setBounds((frameWidth/4)-40, 5, 150, 16);
        leftHL.setFont(new Font("Verdana", Font.BOLD, 14));
        f.add(leftHL);
    }

    void printLeftGridTopLabels() {
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

    void printLeftGridSideLabels() {
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

    void printLeftGridButtons(GameProgress gameProgress) {
        int width = 79;
        int height = 79;
        int x = 1;

        for(int i = 0; i < 100; i = i+10){
            for(int j = 1; j <= 10; j++){
                leftB[i+j] = new JButton(new ImageIcon("progData/images/hit3.png"));
                leftB[i+j].setBounds(width,height,44, 44);
                leftB[i+j].setEnabled(true);
                leftB[i+j].setBackground(new Color(0, 0, 180-(15*x)));
                leftB[i+j].setText("leftB" + (i+j));
                leftB[i+j].setForeground(new Color(0, 0, 180-(15*x)));
                leftB[i+j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        gameProgress.setPushedButton(e.getActionCommand());
                        gameProgress.placeShip(gameProgress.getCurrentShip());
                    }
                });
                f.add(leftB[i+j]);
                width = width + 44;
            }
            width = 79;
            height = height + 44;
            x++;
        }
    }

    void printMidLine() {
        JLabel midLine = new JLabel();
        midLine.setBounds(frameWidth/2, 0, 1, frameHeight-36);
        midLine.setBorder(blackline);
        f.add(midLine);
    }

    void printRightGridHeadLabel() {
        JLabel rightHL = new JLabel("Opponents field");
        rightHL.setBounds((frameWidth/4)*3-54, 5, 150, 18);
        rightHL.setFont(new Font("Verdana", Font.BOLD, 14));

        f.add(rightHL);
    }

    void printRightGridTopLabels() {
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

    void printRightGridSideLabels() {
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

    void printRightGridButtons(GameProgress gameProgress) {
        int width = (frameWidth/2) + 79;
        int height = 79;
        int x = 1;

        for(int i = 0; i < 100; i = i+10){
            for(int j = 1; j <= 10; j++){
                rightB[i+j] = new JButton();
                rightB[i+j].setBounds(width, height,44, 44);
                rightB[i+j].setEnabled(true);
                rightB[i+j].setBackground(new Color(0, 0, 180-(15*x)));
                rightB[i+j].setText("rightB" + (i+j));
                rightB[i+j].setForeground(new Color(0, 0, 180-(15*x)));
                rightB[i+j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        gameProgress.setPushedButton(e.getActionCommand());
                        f.setEnabled(false);
                        gameProgress.setTurn();
                        rightGridArray[Integer.parseInt(e.getActionCommand().substring(6))][1] = 1;
                        if(rightGridArray[Integer.parseInt(e.getActionCommand().substring(6))][0] > 0) {
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setIcon(hit);
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setEnabled(false);
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setDisabledIcon(hit);
                        } else {
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setIcon(noHit);
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setEnabled(false);
                            rightB[Integer.parseInt(e.getActionCommand().substring(6))].setDisabledIcon(noHit);
                        }

                    }
                });
                f.add(rightB[i+j]);
                width = width + 44;
                rightB[i+j].repaint();
            }
            width = (frameWidth/2) + 79;
            height = height + 44;
            x++;
        }
    }

    void placeOpponentsShipOnRightGrid() {
        rightGridArray[1][0] = 1;
        rightGridArray[2][0] = 1;
        rightGridArray[3][0] = 1;
        rightGridArray[4][0] = 1;
        rightGridArray[5][0] = 1;

        /*
        1	  Carrier	        5
        2	  Battleship	    4
        3	  Cruiser	        3
        4	  Submarine 	    3
        5	  Destroyer	        2
    */
    }





}



