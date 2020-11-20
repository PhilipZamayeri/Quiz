package Klient.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AnswerListener implements ActionListener {

    private ObjectOutputStream oos;

    public AnswerListener(ObjectOutputStream oos) {
        this.oos = oos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton button = (JButton)e.getSource();
            System.out.println(button.getText());
            try {
                oos.writeObject(button.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
