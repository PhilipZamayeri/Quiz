package Klient.gui;

import Server.NewGameRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NewGamePanel extends JPanel {

    //JLabel nyttSpel = new JLabel();
    JButton newSpel = new JButton("New Spel");

    public NewGamePanel(ObjectOutputStream oos) {
        setLayout(new BorderLayout());
        //JPanel buttonPanel = new JPanel();
        newSpel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    oos.writeObject(new NewGameRequest());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        add(newSpel);

    }

}