package Server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket clientSocket;
    QuestionHandler question;

    public ClientHandler(Socket clientSocket, QuestionHandler question) {
        this.clientSocket = clientSocket;
        this.question = question;
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String input;
            QuestionHandler questionHandler = new QuestionHandler();

            writer.println(questionHandler.handleQuestion(null).toString());

            while ((input = reader.readLine()) != null) {
                System.out.println("Get message " + input);
                writer.println("Du skrev: " + questionHandler.handleQuestion(input).toString());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
