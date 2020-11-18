package Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-17
 * Time: 11:11
 * Project: Quiz
 * Copyright: MIT
 */
public class GUI extends JFrame{
    DAO dao = new DAO();

    private int correctAnswers = 0;
    private int result = 0;

    JFrame frame = new JFrame("QUIZ");

    JPanel mainPanel = new JPanel();

    JPanel gamePanel = new JPanel();

    JPanel categoriesPanel = new JPanel();
    JButton categoryButton1 = new JButton("Geografi");
    JButton categoryButton2 = new JButton("Sport");
    JButton categoryButton3 = new JButton("Nöje");
    JButton categoryButton4 = new JButton("Matematik");


    JButton newGame = new JButton("Nytt spel");
    JButton testButton = new JButton("TEST");

    JLabel question;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;


    public GUI() {


        add(mainPanel);
        mainPanel.setSize(400, 500);
        mainPanel.setBackground(new Color(127, 61, 61));
        mainPanel.setLayout(null);

        newGame.setBounds(50, 150, 300, 50);
        //newGame.setLocation(100, 200);
        //newGame.setPreferredSize(new Dimension(300, 50));
        newGame.setBackground(new Color(0x9252260E, true));
        newGame.setOpaque(true);

        testButton.setBounds(50, 200, 300, 50);

        newGame.addMouseListener(newGameListener);

        mainPanel.add(newGame);
        mainPanel.add(testButton);

        setVisible(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void categories() {
        categoryButton1.addMouseListener(chooseCategoryListener);
        categoryButton2.addMouseListener(chooseCategoryListener);
        categoryButton3.addMouseListener(chooseCategoryListener);
        categoryButton4.addMouseListener(chooseCategoryListener);

        mainPanel.setVisible(false);
        add(categoriesPanel);

        categoriesPanel.setBackground(new Color(127, 61, 61));
        categoriesPanel.setLayout(null);

        categoriesPanel.add(categoryButton1);
        categoriesPanel.add(categoryButton2);
        categoriesPanel.add(categoryButton3);
        categoriesPanel.add(categoryButton4);

        categoryButton1.setBounds(50, 150, 300, 50);
        categoryButton2.setBounds(50, 210, 300, 50);
        categoryButton3.setBounds(50, 270, 300, 50);
        categoryButton4.setBounds(50, 330, 300, 50);

        setVisible(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void startNewGame() {

        categoriesPanel.setVisible(false);
        add(gamePanel);

        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);
        gamePanel.add(button4);
        gamePanel.add(question);


        question.setLocation(50, 100);
        question.setSize(300, 50);
        question.setVisible(true);

        button1.setBounds(30, 200, 155, 50);
        button2.setBounds(215, 200, 155, 50);
        button3.setBounds(30, 250, 155, 50);
        button4.setBounds(215, 250, 155, 50);

        gamePanel.setBackground(new Color(127, 61, 61));
        gamePanel.setLayout(null);

        setVisible(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void questionSetup(List<Question> category){
        Collections.shuffle(category);
        question = new JLabel(category.get(0).getQuestion(), SwingConstants.CENTER);
        button1 = new JButton(category.get(0).getAlternatives().get(0));
        button2 = new JButton(category.get(0).getAlternatives().get(1));
        button3 = new JButton(category.get(0).getAlternatives().get(2));
        button4 = new JButton(category.get(0).getAlternatives().get(3));

        button1.addMouseListener(chooseAlternativesListener);
        button2.addMouseListener(chooseAlternativesListener);
        button3.addMouseListener(chooseAlternativesListener);
        button4.addMouseListener(chooseAlternativesListener);

        startNewGame();

    }

    public void checkAnswer(JButton button){
        if (button.getText().trim().equalsIgnoreCase(dao.sport.get(0).getAnswer()) ||
                button.getText().trim().equalsIgnoreCase(dao.mathematics.get(0).getAnswer()) ||
                button.getText().trim().equalsIgnoreCase(dao.geopgraphy.get(0).getAnswer()) ||
                button.getText().trim().equalsIgnoreCase(dao.pleasure.get(0).getAnswer())){

            System.out.println("Korrekt!");
            correctAnswers++;
        }
        else {
            System.out.println("Fel svar!");
        }
    }

    public void category(MouseEvent e){
        if (categoryButton1 == e.getSource()){
            questionSetup(dao.geopgraphy);
        }
        else if(categoryButton2 == e.getSource()){
            questionSetup(dao.sport);
        }
        else if(categoryButton3 == e.getSource()){
            questionSetup(dao.pleasure);
        }
        else{
            questionSetup(dao.mathematics);
        }
    }

   MouseAdapter chooseAlternativesListener = new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
           super.mouseClicked(e);
           checkAnswer((JButton) e.getSource());
       }
   };

    MouseAdapter chooseCategoryListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            category(e);
        }
    };

    MouseAdapter newGameListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            categories();
        }
    };



    public static void main(String[] args) {
        new GUI();
    }
}
