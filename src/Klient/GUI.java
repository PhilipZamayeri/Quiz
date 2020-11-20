package Klient;

import Server.DAO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-17
 * Time: 11:11
 * Project: Quiz
 * Copyright: MIT
 */
public class GUI extends JFrame {
    DAO QH = new DAO();
    Font question = new Font("Tahoma", Font.BOLD, 40);
    Font alternatives = new Font("Tahoma", Font.PLAIN, 25);


    public void guiCategory() throws IOException {
        JFrame frame = new JFrame("Quiz");

        JPanel board = new JPanel();
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JLabel label = new JLabel("Choose category!", SwingConstants.CENTER);

        JButton b1 = new JButton("History");
        JButton b2 = new JButton("Sport");
        JButton b3 = new JButton("TV");

        //BufferedImage myPicture = ImageIO.read(new File("/Users/philipzamayeri/Desktop/testQuic.jpeg"));
        //JLabel pic = new JLabel(new ImageIcon(myPicture));


        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(board, BorderLayout.NORTH);
        board.setLayout(new BorderLayout());
        //board.add(pic, BorderLayout.NORTH);
        board.add(label, BorderLayout.CENTER);


        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(b1, BorderLayout.NORTH);
        buttonPanel.add(b2, BorderLayout.CENTER);
        buttonPanel.add(b3, BorderLayout.SOUTH);


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);

    }

    public void guiQuestion(){
        JFrame frame = new JFrame("Quiz");
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel(QH.mathematics.get(0).getQuestion(), SwingConstants.CENTER);

        JButton b1 = new JButton("Alternativ 1");
        JButton b2 = new JButton("Alternativ 2");
        JButton b3 = new JButton("Alternativ 3");
        JButton b4 = new JButton("Alternativ 4");

        b1.setFont(alternatives);
        b1.setBackground(Color.YELLOW);
        b1.setOpaque(true);

        b2.setFont(alternatives);
        b2.setBackground(Color.YELLOW);
        b2.setOpaque(true);

        b3.setFont(alternatives);
        b3.setBackground(Color.YELLOW);
        b3.setOpaque(true);

        b4.setFont(alternatives);
        b4.setBackground(Color.YELLOW);
        b4.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        label.setFont(question);
        buttonPanel.setLayout(new GridLayout(2,2));
        panel.add(buttonPanel);

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);
    }

    public void guiBase(){
        JFrame frame = new JFrame("Quiz");
        JPanel panel = new JPanel();
        JButton newGame = new JButton("New game");


        newGame.setFont(question);
        newGame.setSize(30,30);
        panel.setLayout(new BorderLayout());
        panel.add(newGame, BorderLayout.CENTER);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLocation(600, 90);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        gui.guiCategory();
        gui.guiQuestion();
        gui.guiBase();
    }
}
