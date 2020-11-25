package Klient.gui;

import Klient.ClientGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends JPanel {

    JButton newSpel = new JButton("New Spel");

    public NewGamePanel(GameFrame gameFrame) {
        setLayout(new BorderLayout());

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