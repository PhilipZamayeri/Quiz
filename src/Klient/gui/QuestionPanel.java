package Klient.gui;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectOutputStream;

public class QuestionPanel extends JPanel {

    Font questionFont = new Font("Tahoma", Font.BOLD, 40);
    Font alternativesFont = new Font("Tahoma", Font.PLAIN, 25);

    JLabel label= new JLabel("Question here", SwingConstants.CENTER);
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    public QuestionPanel(Question newQuestion, ObjectOutputStream oos) {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        label= new JLabel(newQuestion.getQuestion(), SwingConstants.CENTER);

        b1 = new JButton(newQuestion.getAlternatives().get(0));
        b2 = new JButton(newQuestion.getAlternatives().get(1));
        b3 = new JButton(newQuestion.getAlternatives().get(2));
        b4 = new JButton(newQuestion.getAlternatives().get(3));

        b1.addActionListener(new AnswerListener(oos));
        b2.addActionListener(new AnswerListener(oos));
        b3.addActionListener(new AnswerListener(oos));
        b4.addActionListener(new AnswerListener(oos));

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
}
