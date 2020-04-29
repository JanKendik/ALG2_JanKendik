package pkg08_elevengame;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
    Board board = Board.newBoard();
        

        while (board.isAnotherPlayPossible()) {
            displayGame(board);
            System.out.println("Vyber karty:");
            String[] selectedCardsPositions = sc.nextLine().split(" +");
            while (!board.playAndReplace(selectedCardsPositions)) {
                System.out.println("Nevalidní tah");
                selectedCardsPositions = sc.nextLine().split(" +");
            
            }

        }
        if(board.hasWon()){
            displayGame(board);
            System.out.println("gratuluji");
        }else{
            System.out.println("Nelze hrat");
        }
            
        }

    private static void displayGame(BoardInterface board) {
        System.out.println("***********" + board.getName() + "***********");
        displayCards(board);
        displayDeck(board);
    }
        

    

    

    private static void displayCards(BoardInterface board) {
        for (int i = 0; i < board.nCards(); i++) {
            System.out.format("%1d. %10s    ", i + 1, board.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }

        }

    }

    private static void displayDeck(BoardInterface board) {
        System.out.println("V balíčku zbývá " + board.getDeckSize() + " Karet");
    }

}
