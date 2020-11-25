package Server;

/**
 * Created by Donatas Auzelis
 * Date: 2020-11-20
 * Time: 14:05
 * Project: Quiz
 * Copyright: MIT
 */
public class Protocol {

    private final int WAITING = 0;
    private final int BOTHCONNECTED = 1;
    private final int SENTTOPLAYER1 = 2;
    private final int PLAYER1ANSWERED = 3;
    private final int SENTTOPLAYER2 = 4;
    private final int PLAYER2ANSWERED = 5;
    private final int VALIDATIONSENT = 6;

    private int gameState = WAITING;

    public void process() {

        if (gameState == WAITING) {
            //Nånting här
            //Vänta tills båda ansluter sig
            gameState = BOTHCONNECTED;
        } else if (gameState == BOTHCONNECTED) {
            //Starta spelet
            //Skicka frågorna
            gameState = SENTTOPLAYER1;
        } else if (gameState == SENTTOPLAYER1) {
            //Skicka fråga till player 1
            gameState = SENTTOPLAYER2;
        } else if (gameState == SENTTOPLAYER2) {
            //Skicka fråga till player 2
            gameState = PLAYER1ANSWERED;4
        } else if (gameState == PLAYER1ANSWERED) {
            //Kontrollera svar
            gameState = PLAYER2ANSWERED;
        } else if (gameState == PLAYER2ANSWERED) {
            //Kontrollera svar
            gameState = VALIDATIONSENT;
        } else if (gameState == VALIDATIONSENT) {

        }

    }

}
