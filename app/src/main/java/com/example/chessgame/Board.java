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
        figures.put(new Coordinate(1,2), new Knight(WHITE));
        figures.put(new Coordinate(1,3), new Bishop(WHITE));
        figures.put(new Coordinate(1,4), new Queen(WHITE));
        figures.put(new Coordinate(1,5), new King(WHITE));
        figures.put(new Coordinate(1,6), new Bishop(WHITE));
        figures.put(new Coordinate(1,7), new Knight(WHITE));
        figures.put(new Coordinate(1,8), new Rook(WHITE));

        figures.put(new Coordinate(2,1), new Pawn(WHITE));
        figures.put(new Coordinate(2,2), new Pawn(WHITE));
        figures.put(new Coordinate(2,3), new Pawn(WHITE));
        figures.put(new Coordinate(2,4), new Pawn(WHITE));
        figures.put(new Coordinate(2,5), new Pawn(WHITE));
        figures.put(new Coordinate(2,6), new Pawn(WHITE));
        figures.put(new Coordinate(2,7), new Pawn(WHITE));
        figures.put(new Coordinate(2,8), new Pawn(WHITE));

        figures.put(new Coordinate(7,1), new Pawn(BLACK));
        figures.put(new Coordinate(7,2), new Pawn(BLACK));
        figures.put(new Coordinate(7,3), new Pawn(BLACK));
        figures.put(new Coordinate(7,4), new Pawn(BLACK));
        figures.put(new Coordinate(7,5), new Pawn(BLACK));
        figures.put(new Coordinate(7,6), new Pawn(BLACK));
        figures.put(new Coordinate(7,7), new Pawn(BLACK));
        figures.put(new Coordinate(7,8), new Pawn(BLACK));

        figures.put(new Coordinate(8,1), new Rook(BLACK));
        figures.put(new Coordinate(8,2), new Knight(BLACK));
        figures.put(new Coordinate(8,3), new Bishop(BLACK));
        figures.put(new Coordinate(8,4), new Queen(BLACK));
        figures.put(new Coordinate(8,5), new King(BLACK));
        figures.put(new Coordinate(8,6), new Bishop(BLACK));
        figures.put(new Coordinate(8,7), new Knight(BLACK));
        figures.put(new Coordinate(8,8), new Rook(BLACK));

    }


    public Map<Coordinate, Figure> getFigures(){
        return figures;
    }


    public void setFigures(Map<Coordinate, Figure> figures) {
        this.figures = figures;
    }
}
