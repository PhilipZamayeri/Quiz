package Klient;

import Klient.gui.GameFrame;
import Server.Question;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public Client() throws IOException, ClassNotFoundException {

        InetAddress iadr = InetAddress.getLocalHost();
        int portnr= 57777;

        Socket socketToServer = new Socket(iadr,portnr);
        System.out.println("Connected to server.");
        ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
        ObjectInputStream ooi = new ObjectInputStream(socketToServer.getInputStream());

        GameFrame gameFrame =
                new GameFrame(oos);

        Object incomingObject;
        //Scanner sc= new Scanner(System.in);

        while((incomingObject = ooi.readObject())!=null) {
            System.out.println("Server: " + incomingObject);
            //Kollar om incomingObject är en Question
            if(incomingObject instanceof Question) {
                gameFrame.getQuestionPanel().addQuestionToPanel((Question) incomingObject);
            } else if(incomingObject instanceof String) {
                String resultat = (String) incomingObject;
                if(resultat.contains("korrekt")) {
                    //Ändra färg
                } else {
                    //Ändra färg
                }
            }
            //String input = sc.next();
            //System.out.println(input);
            //oos.writeObject(input);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client();
    }
}
