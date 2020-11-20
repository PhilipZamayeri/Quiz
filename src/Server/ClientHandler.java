package Server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket clientSocket;
    DAO questionsDatabase;

    public ClientHandler(Socket clientSocket, DAO questionsDatabase) {
        this.clientSocket = clientSocket;
        this.questionsDatabase = questionsDatabase;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());

            //DAO questionHandler = new DAO();

            Question question = (Question) questionsDatabase.handleQuestion(null);
            //Skickar fråga till Clienten
            writer.writeObject(question);

            Object input;
            while ((input = reader.readObject()) != null) {
                System.out.println("Get message " + input);

                if (input.equals(question.getAnswer())){
                    writer.writeObject("Svaret är korrekt! " + input);
                }
                else {
                    writer.writeObject("Svaret är fel! " + input);
                }

            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
