package Server;

import java.io.*;
import java.net.Socket;
import java.util.Collections;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-17
 * Time: 11:22
 * Project: Quiz
 * Copyright: MIT
 */
public class ClientHandler extends Thread{
    ClientHandler opponent;
    Socket clientSocket;
    DAO question;

    public ClientHandler(Socket clientSocket, DAO question) {
        this.clientSocket = clientSocket;
        this.question = question;
    }

    public void setOpponent(ClientHandler opponent) {
        this.opponent = opponent;
    }

    public ClientHandler getOpponent() {
        return opponent;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());

            Object input;
            DAO questionHandler = new DAO();

            writer.writeObject(questionHandler.handleQuestion(null).toString());

            while ((input = reader.readObject()) != null) {
                System.out.println("Get message " + input);

                if (input.equals(questionHandler.m1.getAnswer())){
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
