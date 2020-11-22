package Klient.gui;

import Server.DAO;
import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

public class CategoriePanel extends JPanel {
    DAO dao=new DAO();
    //JPanel mainPanel = new JPanel();


    //JPanel categoriesPanel = new JPanel();
    JButton categoryButton1 = new JButton("Geografi");
    JButton categoryButton2 = new JButton("Sport");
    JButton categoryButton3 = new JButton("Nöje");
    JButton categoryButton4 = new JButton("Matematik");

    JLabel question;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;


    public CategoriePanel(ObjectOutputStream oos) {

        categoryButton1.addActionListener(new AnswerListener(oos));
        categoryButton2.addActionListener(new AnswerListener(oos));
        categoryButton3.addActionListener(new AnswerListener(oos));
        categoryButton4.addActionListener(new AnswerListener(oos));



        setBackground(new Color(127, 61, 61));
        setLayout(null);

        add(categoryButton1);
        add(categoryButton2);
        add(categoryButton3);
        add(categoryButton4);

        categoryButton1.setBounds(50, 150, 300, 50);
        categoryButton2.setBounds(50, 210, 300, 50);
        categoryButton3.setBounds(50, 270, 300, 50);
        categoryButton4.setBounds(50, 330, 300, 50);

       // setVisible(true);
       // setSize(400, 500);


    }
    public void questionSetup(List<Question> category) {
       // Collections.shuffle(category);
        question = new JLabel(category.get(0).getQuestion(), SwingConstants.CENTER);
        button1 = new JButton(category.get(0).getAlternatives().get(0));
        button2 = new JButton(category.get(0).getAlternatives().get(1));
        button3 = new JButton(category.get(0).getAlternatives().get(2));
        button4 = new JButton(category.get(0).getAlternatives().get(3));

        button1.addMouseListener(chooseAlternativesListener);
        button2.addMouseListener(chooseAlternativesListener);
        button3.addMouseListener(chooseAlternativesListener);
        button4.addMouseListener(chooseAlternativesListener);

        //startNewGame();

    }



    public void category(MouseEvent e) {
        if (categoryButton1 == e.getSource()) {
            questionSetup(dao.geopgraphy);
        } else if (categoryButton2 == e.getSource()) {
            questionSetup(dao.sport);
        } else if (categoryButton3 == e.getSource()) {
            questionSetup(dao.pleasure);
        } else {
            questionSetup(dao.mathematics);
        }
    }

    MouseAdapter chooseAlternativesListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
          //  checkAnswer((JButton) e.getSource());
        }
    };




}


