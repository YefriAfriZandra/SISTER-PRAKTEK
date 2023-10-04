/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Yefri13092003;

//public class PrintNameThread extends Thread {
//    PrintNameThread(String name) {
//            super(name);
//            // menjalankan thread dengan satu kali instantiate
//        start(); }
//        public void run() {
//            String name = getName();
//            for (int i = 0; i < 100; i++) {
//            System.out.print(name);
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Banner {

    private JFrame frame;
    private JPanel bannerPanel;
    private JLabel bannerLabel;
    private JLabel movingTextLabel; 
    private String bannerText;
    private String movingText; 
    private int bannerPosition;
    private int movingTextPosition; 
    private Timer timer;

    public Banner() {
        frame = new JFrame("Banner Example");
        bannerPanel = new JPanel();
        bannerText = "Yefri AFri Zandra! ";
        movingText = "Teknologi Rekayasa Perangkat Lunak ";

        bannerPosition = 0;
        movingTextPosition = movingText.length();

        bannerLabel = new JLabel(bannerText);
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        movingTextLabel = new JLabel(movingText);
        movingTextLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        bannerPanel.setLayout(new BorderLayout());
        
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
        bannerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
        bannerPanel.add(movingTextLabel, BorderLayout.SOUTH);

        frame.add(bannerPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBanner();
                moveMovingText();
            }
        });

        timer.start();
    }

    private void moveBanner() {
        bannerPosition++;
        if (bannerPosition > bannerText.length()) {
            bannerPosition = 0;
        }

        String displayText = bannerText.substring(bannerPosition) + bannerText.substring(0, bannerPosition);
        bannerLabel.setText(displayText);
    }

    private void moveMovingText() {
        movingTextPosition--;
        if (movingTextPosition < 0) {
            movingTextPosition = movingText.length();
        }

        String displayText = movingText.substring(movingTextPosition) + movingText.substring(0, movingTextPosition);
        movingTextLabel.setText(displayText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Banner().frame.setVisible(true);
            }
        });
    }
}