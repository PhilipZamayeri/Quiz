package Klient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws IOException {
        InetAddress iadr= InetAddress.getLocalHost();
        int portnr= 33333;

        Socket sockettoservern = new Socket(iadr,portnr);
        System.out.println("Connected to server.");
        PrintWriter writer = new PrintWriter(sockettoservern.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(sockettoservern.getInputStream()));

        String server;
        Scanner sc= new Scanner(System.in);

        while((server= reader.readLine())!=null) {
            System.out.println("Server: " + server);
            String input = sc.next();
            System.out.println(input);
            writer.println(input);
        }
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
