package Klient.gui;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectOutputStream;
import java.util.List;

public class GameFrame extends JFrame {

    private QuestionPanel questionPanel;
    private NewGamePanel newGamePanel;
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private CategoriePanel categoriePanel;

    public GameFrame(ObjectOutputStream oos) {
        super("Quiz");
        questionPanel = new QuestionPanel(new Question("Q1", "Rätt", List.of("Fel", "Rätt", "Misstag", "Fel igen")), oos);
        newGamePanel = new NewGamePanel(oos);
        categoriePanel= new CategoriePanel(oos);
        //add(questionPanel);
        add(mainPanel);
        mainPanel.add(newGamePanel);
        //mainPanel.add(categoriePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocation(600, 90);
        setVisible(true);
    }

    public QuestionPanel getQuestionPanel() {
        return questionPanel;
    }

    public void changeToQuestionPanel() {
        System.out.println("Changing to QuestionPanel");
        mainPanel.removeAll();
        mainPanel.add(questionPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void changeToNewGamePanel() {
        System.out.println("Changing to NewGamePanel");
        mainPanel.removeAll();
        mainPanel.add(newGamePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void changeToCatagoriesPanel(){
        System.out.println("Hi I am here CatagoriesPanel yeee....");
        mainPanel.removeAll();
        mainPanel.add(categoriePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}

