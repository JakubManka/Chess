package com.example.chessgame;

import com.example.chessgame.figures.Bishop;
import com.example.chessgame.figures.Figure;
import com.example.chessgame.figures.King;
import com.example.chessgame.figures.Knight;
import com.example.chessgame.figures.Pawn;
import com.example.chessgame.figures.Queen;
import com.example.chessgame.figures.Rook;

import java.util.HashMap;
import java.util.Map;

import static com.example.chessgame.FigureColor.*;
import static com.example.chessgame.FigureColor.BLACK;

public class Board {


    private Map<Coordinate, Figure> figures = new HashMap<>();
    private int player1Time;
    private int player2Time;

    Board(){
        // x = [A-H] [1-8]
        // y = [1-8] [1-8]
        figures.put(new Coordinate(1,1), new Rook(WHITE));
        figures.put(new Coordinate(2,1), new Knight(WHITE));
        figures.put(new Coordinate(3,1), new Bishop(WHITE));
        figures.put(new Coordinate(4,1), new Queen(WHITE));
        figures.put(new Coordinate(5,1), new King(WHITE));
        figures.put(new Coordinate(6,1), new Bishop(WHITE));
        figures.put(new Coordinate(7,1), new Knight(WHITE));
        figures.put(new Coordinate(8,1), new Rook(WHITE));

        figures.put(new Coordinate(1,2), new Pawn(WHITE));
        figures.put(new Coordinate(2,2), new Pawn(WHITE));
        figures.put(new Coordinate(3,2), new Pawn(WHITE));
        figures.put(new Coordinate(4,2), new Pawn(WHITE));
        figures.put(new Coordinate(5,2), new Pawn(WHITE));
        figures.put(new Coordinate(6,2), new Pawn(WHITE));
        figures.put(new Coordinate(7,2), new Pawn(WHITE));
        figures.put(new Coordinate(8,2), new Pawn(WHITE));

        figures.put(new Coordinate(1,7), new Pawn(BLACK));
        figures.put(new Coordinate(2,7), new Pawn(BLACK));
        figures.put(new Coordinate(3,7), new Pawn(BLACK));
        figures.put(new Coordinate(4,7), new Pawn(BLACK));
        figures.put(new Coordinate(5,7), new Pawn(BLACK));
        figures.put(new Coordinate(6,7), new Pawn(BLACK));
        figures.put(new Coordinate(7,7), new Pawn(BLACK));
        figures.put(new Coordinate(8,7), new Pawn(BLACK));

        figures.put(new Coordinate(1,8), new Rook(BLACK));
        figures.put(new Coordinate(2,8), new Knight(BLACK));
        figures.put(new Coordinate(3,8), new Bishop(BLACK));
        figures.put(new Coordinate(4,8), new Queen(BLACK));
        figures.put(new Coordinate(5,8), new King(BLACK));
        figures.put(new Coordinate(6,8), new Bishop(BLACK));
        figures.put(new Coordinate(7,8), new Knight(BLACK));
        figures.put(new Coordinate(8,8), new Rook(BLACK));

    }


    public Map<Coordinate, Figure> getFigures(){
        return figures;
    }



}
