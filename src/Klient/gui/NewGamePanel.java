package Klient.gui;

import Klient.ClientGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends JPanel{
    JPanel mainPanel = new JPanel();
    JButton newSpel = new JButton("Nytt spel");

    public NewGamePanel(GameFrame gameFrame) {
        add(mainPanel);
        mainPanel.setSize(400, 500);
        mainPanel.setBackground(new Color(127, 61, 61));
        mainPanel.setLayout(null);

        newSpel.setBounds(50, 150, 300, 50);

        newSpel.setBackground(new Color(127, 61, 61));

        newSpel.setOpaque(true);

        //mainPanel.add(newSpel);

        setVisible(true);
        setSize(400, 500);
        gameFrame.setLocationRelativeTo(null);

        newSpel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientGame clientGame = new ClientGame(gameFrame);
                Thread thread = new Thread(clientGame);
                thread.start();
            }
        });
        add(newSpel);

    }

}