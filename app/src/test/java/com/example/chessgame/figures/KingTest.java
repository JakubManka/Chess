package com.example.chessgame.figures;

import com.example.chessgame.Board;
import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class KingTest {
    private King king = new King(FigureColor.BLACK);
    private Coordinate coordinates;
    private Map<Coordinate, Figure> map = new HashMap<>();
//    private Board board = new Board();

    @Test
    public void notAbleToMove() {
        coordinates = new Coordinate(3, 3);
        map.put(new Coordinate(2, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 3), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 4), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(3, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(3, 4), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(4, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(4, 3), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(4, 4), new Pawn(FigureColor.BLACK));
        assertTrue("list should be empty", king.whereCanIMove(map, coordinates, FigureColor.WHITE).isEmpty());
    }

    @Test
    public void ableToMove() {
        coordinates = new Coordinate(3, 3);
        List list = king.whereCanIMove(map, coordinates, FigureColor.WHITE);
        assertTrue(list.contains(new Coordinate(2, 2)));
        assertTrue(list.contains(new Coordinate(2, 3)));
        assertTrue(list.contains(new Coordinate(2, 4)));
        assertTrue(list.contains(new Coordinate(3, 2)));
        assertTrue(list.contains(new Coordinate(3, 4)));
        assertTrue(list.contains(new Coordinate(4, 2)));
        assertTrue(list.contains(new Coordinate(4, 3)));
        assertTrue(list.contains(new Coordinate(4, 4)));
        assertEquals(list.size(), 8);
    }

    @Test
    public void ableToHitPawn() {
        coordinates = new Coordinate(3, 3);
        map.put(new Coordinate(2, 2), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(2, 3), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(2, 4), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(3, 2), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(3, 4), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(4, 2), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(4, 3), new Pawn(FigureColor.WHITE));
        map.put(new Coordinate(4, 4), new Pawn(FigureColor.WHITE));
        List list = king.whereCanIMove(map, coordinates, FigureColor.WHITE);
        assertTrue(list.contains(new Coordinate(2, 2)));
        assertTrue(list.contains(new Coordinate(2, 3)));
        assertTrue(list.contains(new Coordinate(2, 4)));
        assertTrue(list.contains(new Coordinate(3, 2)));
        assertTrue(list.contains(new Coordinate(3, 4)));
        assertTrue(list.contains(new Coordinate(4, 2)));
        assertTrue(list.contains(new Coordinate(4, 3)));
        assertTrue(list.contains(new Coordinate(4, 4)));
        assertEquals(list.size(), 8);
    }
//    @Test
//    public void kingMoves(){
//        coordinates = new Coordinate(3, 3);
//        map.put(coordinates, king);
//        map.put(new Coordinate(6,6), new Queen(FigureColor.WHITE));
//        board.kingc
//
//        board.setBoardStatus(map);
//        List list = board.getKingMoves();
//        assertTrue(list.contains(new Coordinate(4,3)));
//        assertTrue(list.contains(new Coordinate(4,2)));
//        assertTrue(list.contains(new Coordinate(3,2)));
//        assertTrue(list.contains(new Coordinate(3,4)));
//        assertTrue(list.contains(new Coordinate(2,4)));
//        assertTrue(list.contains(new Coordinate(2,3)));
//        assertEquals(list.size(), 6);
//
//    }

}