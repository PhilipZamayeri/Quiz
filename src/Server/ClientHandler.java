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
            //NewGameGui nyttSpel= new NewGameGui();

            //Skickar fråga till Clienten


            Object input;
            while ((input = reader.readObject()) != null) {
                System.out.println("Get message " + input);

                if(input instanceof NewGameRequest) {
                    writer.writeObject("Välj catagorie");
                }
                else if(input.equals("Geografi")){
                    question = questionsDatabase.g1;
                    writer.writeObject(question);
                }
                else if(input.equals("Nöje")){
                    question = questionsDatabase.p1;
                    writer.writeObject(question);
                }
                else if(input.equals("Sport")){
                    question = questionsDatabase.s1;
                    writer.writeObject(question);
                }
                else if(input.equals("Matematik")){
                    question = questionsDatabase.m1;
                    writer.writeObject(question);
                }
                else if (input.equals(question.getAnswer())){
                    writer.writeObject("Svaret är korrekt! " + input);
                } else {
                    writer.writeObject("Svaret är fel! " + input);
                }

            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
