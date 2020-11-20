package Server;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String question;
    private List<String> alternatives;
    private String answer;

    public Question(String question, String answer, List<String> alternatives) {
        this.question = question;
        this.answer = answer;
        this.alternatives = alternatives;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", alternatives=" + alternatives +
                ", answer='" + answer + '\'' +
                '}';
    }

    public List<String> getAlternatives() {
        return alternatives;
    }
}
