package com.example.chessgame;

import android.os.CountDownTimer;

import com.example.chessgame.figures.Bishop;
import com.example.chessgame.figures.Figure;
import com.example.chessgame.figures.King;
import com.example.chessgame.figures.Knight;
import com.example.chessgame.figures.Pawn;
import com.example.chessgame.figures.Queen;
import com.example.chessgame.figures.Rook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.chessgame.FigureColor.BLACK;
import static com.example.chessgame.FigureColor.WHITE;

public class Board {
    private static final long TIME_IN_MILLIS = 600000;

    private Map<Coordinate, Figure> figures = new HashMap<>();
    private long player1Time = TIME_IN_MILLIS;
    private long player2Time = TIME_IN_MILLIS;
    private Player whitePlayer = new Player(WHITE);
    private Player blackPlayer = new Player(BLACK);
    private List<Map<Coordinate, Figure>> allMoves = new ArrayList<>();
    private CountDownTimer timer;


    Board() {
        // x = [A-H] [1-8]
        // y = [1-8] [1-8]
        figures.put(new Coordinate(1, 1), new Rook(WHITE));
        figures.put(new Coordinate(1, 2), new Knight(WHITE));
        figures.put(new Coordinate(1, 3), new Bishop(WHITE));
        figures.put(new Coordinate(1, 4), new Queen(WHITE));
        figures.put(new Coordinate(1, 5), new King(WHITE));
        figures.put(new Coordinate(1, 6), new Bishop(WHITE));
        figures.put(new Coordinate(1, 7), new Knight(WHITE));
        figures.put(new Coordinate(1, 8), new Rook(WHITE));

        figures.put(new Coordinate(2, 1), new Pawn(WHITE));
        figures.put(new Coordinate(2, 2), new Pawn(WHITE));
        figures.put(new Coordinate(2, 3), new Pawn(WHITE));
        figures.put(new Coordinate(2, 4), new Pawn(WHITE));
        figures.put(new Coordinate(2, 5), new Pawn(WHITE));
        figures.put(new Coordinate(2, 6), new Pawn(WHITE));
        figures.put(new Coordinate(2, 7), new Pawn(WHITE));
        figures.put(new Coordinate(2, 8), new Pawn(WHITE));

        figures.put(new Coordinate(7, 1), new Pawn(BLACK));
        figures.put(new Coordinate(7, 2), new Pawn(BLACK));
        figures.put(new Coordinate(7, 3), new Pawn(BLACK));
        figures.put(new Coordinate(7, 4), new Pawn(BLACK));
        figures.put(new Coordinate(7, 5), new Pawn(BLACK));
        figures.put(new Coordinate(7, 6), new Pawn(BLACK));
        figures.put(new Coordinate(7, 7), new Pawn(BLACK));
        figures.put(new Coordinate(7, 8), new Pawn(BLACK));

        figures.put(new Coordinate(8, 1), new Rook(BLACK));
        figures.put(new Coordinate(8, 2), new Knight(BLACK));
        figures.put(new Coordinate(8, 3), new Bishop(BLACK));
        figures.put(new Coordinate(8, 4), new Queen(BLACK));
        figures.put(new Coordinate(8, 5), new King(BLACK));
        figures.put(new Coordinate(8, 6), new Bishop(BLACK));
        figures.put(new Coordinate(8, 7), new Knight(BLACK));
        figures.put(new Coordinate(8, 8), new Rook(BLACK));

        whitePlayer.setMyMove(true);
        blackPlayer.setMyMove(false);
        addMove();

    }


    public Map<Coordinate, Figure> getFigures() {
        return figures;
    }


    public void setFigures(Map<Coordinate, Figure> figures) {
        this.figures = figures;
    }

    FigureColor whichPlayer() {
        if (whitePlayer.getMyMove()) return WHITE;
        else return BLACK;
    }

    void changePlayer(){
        if(whitePlayer.getMyMove()){
            whitePlayer.setMyMove(false);
            blackPlayer.setMyMove(true);
            startTimer(player1Time);
            pauseTimer();
        }else{
            whitePlayer.setMyMove(true);
            blackPlayer.setMyMove(false);
            startTimer(player2Time);
            pauseTimer();
        }
    }

    private void pauseTimer() {

    }

    private void startTimer(long player) {
        timer = new CountDownTimer(player, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                player = millisUntilFinished;
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    void addMove(){
        allMoves.add(figures);
    }

    void undoLastMove()
    {
        allMoves.remove(allMoves.size()-1);
        figures = allMoves.get(allMoves.size()-1);
    }
}
