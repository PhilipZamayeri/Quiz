package Klient.gui;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class QuestionPanel extends JPanel {

    Font questionFont = new Font("Tahoma", Font.BOLD, 40);
    Font alternativesFont = new Font("Tahoma", Font.PLAIN, 25);

    JLabel label= new JLabel("Question here", SwingConstants.CENTER);
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    JButton lastClickedButton;

    public QuestionPanel(Question newQuestion, ObjectOutputStream oos) {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        label= new JLabel(newQuestion.getQuestion(), SwingConstants.CENTER);

        b1 = new JButton(newQuestion.getAlternatives().get(0));
        b2 = new JButton(newQuestion.getAlternatives().get(1));
        b3 = new JButton(newQuestion.getAlternatives().get(2));
        b4 = new JButton(newQuestion.getAlternatives().get(3));

        b1.addActionListener(new InternalAnswerListener(oos));
        b2.addActionListener(new InternalAnswerListener(oos));
        b3.addActionListener(new InternalAnswerListener(oos));
        b4.addActionListener(new InternalAnswerListener(oos));

        b1.setFont(alternativesFont);
        b1.setBackground(Color.YELLOW);
        b1.setOpaque(true);

        b2.setFont(alternativesFont);
        b2.setBackground(Color.YELLOW);
        b2.setOpaque(true);

        b3.setFont(alternativesFont);
        b3.setBackground(Color.YELLOW);
        b3.setOpaque(true);

        b4.setFont(alternativesFont);
        b4.setBackground(Color.YELLOW);
        b4.setOpaque(true);

        add(label, BorderLayout.NORTH);
        label.setFont(questionFont);
        buttonPanel.setLayout(new GridLayout(2,2));
        add(buttonPanel);

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
    }

    public void addQuestionToPanel(Question question) {
        label.setText(question.getQuestion());
        label.revalidate();
        label.repaint();
        b1.setText(question.getAlternatives().get(0));
        b2.setText(question.getAlternatives().get(1));
        b3.setText(question.getAlternatives().get(2));
        b4.setText(question.getAlternatives().get(3));
        System.out.println(question.getQuestion());
        validate();
    }

    public void setClickedButtonColor(Color color) {
        if(lastClickedButton != null) {
            lastClickedButton.setBackground(color);
            lastClickedButton.revalidate();
            lastClickedButton.repaint();
        }

    }

    public class InternalAnswerListener implements ActionListener {

        private ObjectOutputStream oos;

        public InternalAnswerListener(ObjectOutputStream oos) {
            this.oos = oos;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton) {
                JButton button = (JButton)e.getSource();
                lastClickedButton = button;
                System.out.println(button.getText());
                try {
                    oos.writeObject(button.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
