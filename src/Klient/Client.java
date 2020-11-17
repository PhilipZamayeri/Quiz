package Klient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws IOException, ClassNotFoundException {
        InetAddress iadr= InetAddress.getLocalHost();
        int portnr= 57777;

        Socket socketToServer = new Socket(iadr,portnr);
        System.out.println("Connected to server.");
        ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
        ObjectInputStream ooi = new ObjectInputStream(socketToServer.getInputStream());

        Object server;
        Scanner sc= new Scanner(System.in);

        while((server = ooi.readObject())!=null) {
            System.out.println("Server: " + server);
            String input = sc.next();
            System.out.println(input);
            oos.writeObject(input);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client();
    }
}
