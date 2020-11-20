package Klient.gui;

import Server.Question;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.util.List;

public class GameFrame extends JFrame {

    private QuestionPanel questionPanel;

    public GameFrame(ObjectOutputStream oos) {
        super("Quiz");
        questionPanel = new QuestionPanel(new Question("Q1", "Rätt", List.of("Fel", "Rätt", "Misstag", "Fel igen")), oos);

        add(questionPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocation(600, 90);
        setVisible(true);
    }

    public QuestionPanel getQuestionPanel() {
        return questionPanel;
    }
}
