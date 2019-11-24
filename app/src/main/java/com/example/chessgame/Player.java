package com.example.chessgame;



public class Player {
    private FigureColor playerColor;
    private boolean myMove;

    Player(FigureColor playerColor){
        this.playerColor = playerColor;
    }

    public boolean isMyMove() {
        return myMove;
    }

    public FigureColor getPlayerColor() {
        return playerColor;
    }


    public void setMyMove(boolean myMove) {
        this.myMove = myMove;
    }
}


