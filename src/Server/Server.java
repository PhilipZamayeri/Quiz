package Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    QuestionHandler questions= new QuestionHandler();

    public Server() throws IOException {
        int portnr = 57777;
        ServerSocket socket = new ServerSocket(portnr);
        while (true) {
            Socket clientSocket = socket.accept();
            System.out.println("New client connected.");
            ClientHandler clientHandler = new ClientHandler(clientSocket, questions);
            Thread clientHandlerThread = new Thread(clientHandler);
            clientHandlerThread.start();
        }

    }

    public static void main(String[] args) throws IOException {
        Server server= new Server();
    }
}
