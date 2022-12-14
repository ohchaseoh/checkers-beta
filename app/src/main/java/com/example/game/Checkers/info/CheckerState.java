package com.example.game.Checkers.info;

import com.example.game.Checkers.BlackChecker;
import com.example.game.Checkers.Checker;
import com.example.game.Checkers.RedChecker;
import com.example.game.GameFramework.info.GameState;
import java.io.Serializable;

/**
 * Represents the entire game state of Checkers
 * @authors Alex, Chase, Mohammad
 */

public class CheckerState extends GameState implements Serializable {

    private static final String TAG = "CheckerState";
    public static final int MAX_PLAYERS = 2;


    private char[][] board;
    public Checker[][] checkerList;


    private int playerToMove;

    public CheckerState() {
        super();
        board = new char[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = ' ';
            }
        }
        playerToMove = 0;
        checkerList = new Checker[][]
                {{null, new RedChecker(0,1), null, new RedChecker(0,3), null, new RedChecker(0,5), null, new RedChecker(0,7)},
                        {new RedChecker(1,0), null, new RedChecker(1,2),null, new RedChecker(1,4), null, new RedChecker(1,6), null},
                        {null, new RedChecker(2,1), null, new RedChecker(2,3), null, new RedChecker(2,5), null, new RedChecker(2,7)},
                        {null, null, null, null,null, null,null, null},
                        {null, null, null, null,null, null,null, null},
                        {new BlackChecker(5,0), null, new BlackChecker(5,2),null, new BlackChecker(5,4), null, new BlackChecker(5,6), null},
                        {null, new BlackChecker(6,1), null, new BlackChecker(6,3), null, new BlackChecker(6,5), null, new BlackChecker(6,7)},
                        {new BlackChecker(7,0), null, new BlackChecker(7,2),null, new BlackChecker(7,4), null, new BlackChecker(7,6), null}
                };
    }

    public CheckerState(CheckerState orig) {
        super();
        //TODO copy checkerList after creating new empty CheckerList
        board = new char[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = orig.board[i][j];
            }
        }

        playerToMove = orig.playerToMove;
        super.numSetupTurns = orig.numSetupTurns;
        super.currentSetupTurn = orig.currentSetupTurn;
    }

    public char getPiece(int row, int col) {
        // if we're out of bounds or anything, return '?';
        if (board == null || row < 0 || col < 0) return '?';
        if (row >= board.length || col >= board[row].length) return '?';

        // return the character that is in the proper position
        return board[row][col];
    }

    public void setPiece(int row, int col, char piece) {
        // if we're out of bounds or anything, return;
        if (board == null || row < 0 || col < 0) return;
        if (row >= board.length || col >= board[row].length) return;

        // return the character that is in the proper position
        board[row][col] = piece;
    }

    public Checker[][] getCheckerList() {
        return checkerList;
    }

    //Tells whos move it is
    public int getWhoseMove() {
        return playerToMove;
    }

    //Set whos move it is
    public void setWhoseMove(int id) {
        playerToMove = id;
    }
    /*
    public boolean equals(Object object){

        if(! (object instanceof CheckerState)) return false;
        CheckerState checkerState = (CheckerState) object;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.board[i][j] != CheckerState.board[i][j]){
                    return false;
                }
            }
        }

        if (this.playerToMove != CheckerState.playerToMove || this.numSetupTurns != CheckerState.numSetupTurns || this.currentSetupTurn != CheckerState.currentSetupTurn){
            return false;
        }
        return true;

    }
     */
}
