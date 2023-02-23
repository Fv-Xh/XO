package xo.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        Scanner userInputReader = new Scanner(System.in);

        Board board = new Board();
        board.instructionBoard();
        System.out.println("Please enter a position:");
        int position = Integer.parseInt(userInputReader.nextLine());
        board.placePiece(position, "X");

        boolean isGameInProgress = GameResolver.resolve(board.getBoard())==GameResolver.GameState.IN_PROGRESS;//تعريف لقيم ريسولف

        while( isGameInProgress && !board.isFull()){

            board.placePieceRandomly("O");
            board.displayBoard();  //Print Board
            System.out.println("Please enter a position:"); //Choosing a location 
            position = Integer.parseInt(userInputReader.nextLine());
            board.placePiece(position, "X");

            isGameInProgress = GameResolver.resolve(board.getBoard())==GameResolver.GameState.IN_PROGRESS;

        }
        if(!isGameInProgress) {
            board.displayBoard();
            System.out.print(" GAME OVER!!!");
        }
        else board.displayBoard();
    }
}