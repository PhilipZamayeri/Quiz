package Server;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-20
 * Time: 11:22
 * Project: Quiz
 * Copyright: MIT
 */
public class ServerSideGame {
    ClientHandler currentPlayer;
    ClientHandler player1;
    ClientHandler player2;

    public ServerSideGame(ClientHandler player1, ClientHandler player2){
        this.player1 = player1;
        this.player2 = player2;
    }
}
