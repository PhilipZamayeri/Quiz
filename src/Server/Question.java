package Server;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-15
 * Time: 11:22
 * Project: Quiz
 * Copyright: MIT
 */
public class Question implements Serializable {
    String question;
    List<String> alternatives;
    String answer;

    public Question(String question, String answer, List<String> alternatives) {
        setQuestion(question);
        setAnswer(answer);
        setAlternatives(alternatives);
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAlternatives(List<String> alternatives){this.alternatives = alternatives;}

    public List<String> getAlternatives(){return alternatives;}

}
