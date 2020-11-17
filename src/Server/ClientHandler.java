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
            ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());

            Object input;
            QuestionHandler questionHandler = new QuestionHandler();

            writer.writeObject(questionHandler.handleQuestion(null).toString());

            while ((input = reader.readObject()) != null) {
                System.out.println("Get message " + input);
                writer.writeObject("Du skrev: " + questionHandler.handleQuestion(input).toString());
            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
