package com.example.chessgame;

import java.util.HashMap;
import java.util.Map;

public class Board {


    private Map<Coordinate, Figure> figures = new HashMap<>();
    private int player1Time;
    private int player2Time;
    private enum Name {
        White("White"),
        Black("Black"),
        Rook("Rook"),
        Bishop("Bishop"),
        Pawn("Pawn"),
        Queen("Queen"),
        Knight("Knight"),
        King("King");


        Name(String name) {
        }
    }


    Board(){
        // x = [A-H] [1-8]
        // y = [1-8] [1-8]
        figures.put(new Coordinate(1,1), new Rook(Name.White.toString(),Name.Rook.toString()));
        figures.put(new Coordinate(2,1), new Knight(Name.White.toString(),Name.Knight.toString()));
        figures.put(new Coordinate(3,1), new Bishop(Name.White.toString(),Name.Bishop.toString()));
        figures.put(new Coordinate(4,1), new Queen(Name.White.toString(),Name.Queen.toString()));;
        figures.put(new Coordinate(5,1), new King(Name.White.toString(),Name.King.toString()));
        figures.put(new Coordinate(6,1), new Bishop(Name.White.toString(),Name.Bishop.toString()));
        figures.put(new Coordinate(7,1), new Knight(Name.White.toString(),Name.King.toString()));
        figures.put(new Coordinate(8,1), new Rook(Name.White.toString(),Name.Rook.toString()));

        figures.put(new Coordinate(1,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(2,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(3,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(4,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(5,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(6,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(7,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(8,2), new Pawn(Name.White.toString(),Name.Pawn.toString()));

        figures.put(new Coordinate(1,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(2,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(3,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(4,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(5,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(6,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(7,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));
        figures.put(new Coordinate(8,7), new Pawn(Name.Black.toString(),Name.Pawn.toString()));

        figures.put(new Coordinate(1,8), new Rook(Name.Black.toString(),Name.Rook.toString()));
        figures.put(new Coordinate(2,8), new Knight(Name.Black.toString(),Name.Knight.toString()));
        figures.put(new Coordinate(3,8), new Bishop(Name.Black.toString(),Name.Bishop.toString()));
        figures.put(new Coordinate(4,8), new Queen(Name.Black.toString(),Name.Queen.toString()));
        figures.put(new Coordinate(5,8), new King(Name.Black.toString(),Name.King.toString()));
        figures.put(new Coordinate(6,8), new Bishop(Name.Black.toString(),Name.Bishop.toString()));
        figures.put(new Coordinate(7,8), new Knight(Name.Black.toString(),Name.Knight.toString()));
        figures.put(new Coordinate(8,8), new Rook(Name.Black.toString(),Name.Rook.toString()));

    }


    public Map<Coordinate, Figure> getFigures(){
        return figures;
    }



}
