package Server;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    String question;
    List<String> alternatives;
    String answer;

    public Question(String question, String answer, List<String> alternatives) {
        this.question = question;
        this.answer = answer;
        this.alternatives = alternatives;
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

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", alternatives=" + alternatives +
                ", answer='" + answer + '\'' +
                '}';
    }
}
