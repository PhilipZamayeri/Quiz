package Klient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-15
 * Time: 09:36
 * Project: Quiz
 * Copyright: MIT
 */
public class Client {

    public Client() throws IOException, ClassNotFoundException {
        InetAddress iadr = InetAddress.getLocalHost();
        int portnr= 57777;

        Socket socketToServer = new Socket(iadr,portnr);
        ObjectOutputStream writer = new ObjectOutputStream(socketToServer.getOutputStream());
        ObjectInputStream reader = new ObjectInputStream (socketToServer.getInputStream());

        System.out.println("Connected to server.");


        Object server;
        Scanner sc= new Scanner(System.in);

        while((server = reader.readObject())!=null) {
            System.out.println("Server: " + server);
            String input = sc.next();
            System.out.println(input);
            writer.writeObject(input);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client =  new Client();

    }
}
