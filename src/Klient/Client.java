package Klient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException, ClassNotFoundException {
        InetAddress iadr = InetAddress.getLocalHost();
        int portnr= 57777;

        Socket socketToServer = new Socket(iadr,portnr);
        PrintWriter writer = new PrintWriter(socketToServer.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));

        System.out.println("Connected to server.");


        Object server;
        Scanner sc= new Scanner(System.in);

        while((server = reader.readLine())!=null) {
            System.out.println("Server: " + server);
            String input = sc.next();
            System.out.println(input);
            writer.println(input);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Client client =  new Client();

    }
}
