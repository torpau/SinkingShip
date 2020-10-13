package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameBoard {

    public GameBoard(){

    }

    static void initGameBoard(){
        JFrame f=new JFrame();//creating instance of JFrame
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Font font = new Font("Verdana", Font.PLAIN, 12);


        int frameWidth= 900;
        int frameHeight = 400;
        f.setBounds(200, 150, frameWidth, frameHeight);
        //f.getJMenuBar();
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        JButton b=new JButton("");//creating instance of JButton
        b.setBounds((frameWidth-58),30,25, 25);//x axis, y axis, width, height
        b.setEnabled(false);

        JLabel l = new JLabel("A");
        l.setBounds(842,5,40,20);

        l.setBorder(blackline);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setFont(font);


        f.add(l);
        f.add(b);//adding button in JFrame

    }

}



