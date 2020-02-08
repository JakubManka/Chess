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
import java.util.Locale;
import java.util.Map;

import static com.example.chessgame.FigureColor.BLACK;
import static com.example.chessgame.FigureColor.WHITE;
import static com.example.chessgame.FigureName.*;

public class Board {

    private Map<Coordinate, Figure> figures = new HashMap<>();
    private Player whitePlayer = new Player(WHITE);
    private Player blackPlayer = new Player(BLACK);
    private List<Map<Coordinate, Figure>> allMoves = new ArrayList<>(); // all done moves from start
    private Map<Coordinate, List<Coordinate>> possibleMoves = new HashMap<>();
    private  boolean check = false;



    Board() {
        resetBoard();
        whitePlayer.setMyMove(true);
        blackPlayer.setMyMove(false);
        addMove();

    }

    void resetBoard() {
        figures = new HashMap<>();

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
        }else{
            whitePlayer.setMyMove(true);
            blackPlayer.setMyMove(false);
        }
    }

    void checkmate(){

        check = false;

        figures.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().whereCanIMove(figures, e.getKey()).isEmpty())
                .forEach(e -> possibleMoves.put(e.getKey(), e.getValue().whereCanIMove(figures, e.getKey())));

        possibleMoves.values().forEach(e -> {
            e.forEach(z -> {
                figures.entrySet().stream()
                        .filter(f -> f.getValue().getName() == KING)
                        .filter(f -> f.getKey() == z)
                        .forEach(f -> check = true);
            });
                });
        if(check){
            changePlayer();
        }

    }





    void addMove(){

        Map<Coordinate, Figure> oldFigures = new HashMap<>(figures);
        allMoves.add(oldFigures);
    }

    void undoLastMove()
    {
        if(allMoves.size()>0) {
            allMoves.remove(allMoves.size() - 1);
            figures = allMoves.get(allMoves.size() - 1);
        }
    }



}

