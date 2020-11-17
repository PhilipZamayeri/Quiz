package Server;

import java.util.ArrayList;
import java.util.List;

public class QuestionHandler {
    List<Question> history = new ArrayList<>();

    Question h1 = new Question("Vad heter du?", "xoxo", List.of("sdfs","werfw","xoxo","trru"));


    public QuestionHandler() {
        history.add(h1);


    }

    public Object handleQuestion(Object o) {return h1.getQuestion();}

}

