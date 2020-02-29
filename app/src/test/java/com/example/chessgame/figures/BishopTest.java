package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop bishop = new Bishop(FigureColor.BLACK);
    private Coordinate coordinates;
    private Map<Coordinate, Figure> map = new HashMap<>();

    @Test
    public void notAbleToMove() {
        coordinates = new Coordinate(3, 3);
        map.put(new Coordinate(4, 4), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(4, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 4), new Pawn(FigureColor.BLACK));
        assertTrue("list should be empty", bishop.whereCanIMove(map, coordinates, FigureColor.WHITE).isEmpty());
    }

    @Test
    public void ableToMove() {
        coordinates = new Coordinate(3, 3);
        map.put(new Coordinate(5, 5), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(1, 5), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(5, 1), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(1, 1), new Pawn(FigureColor.BLACK));
        List list = bishop.whereCanIMove(map, coordinates, FigureColor.WHITE);
        assertTrue(list.contains(new Coordinate(4, 4)));
        assertTrue(list.contains(new Coordinate(4, 2)));
        assertTrue(list.contains(new Coordinate(2, 4)));
        assertTrue(list.contains(new Coordinate(2, 2)));
        assertEquals(list.size(), 4);
    }

    @Test
    public void ableToHitPawn() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(4, 4), new Pawn(FigureColor.WHITE));
        List list = bishop.whereCanIMove(map, coordinates, FigureColor.WHITE);
        assertTrue(list.contains(new Coordinate(2, 2)));
        assertTrue(list.contains(new Coordinate(3, 3)));
        assertTrue(list.contains(new Coordinate(4, 4)));
        assertEquals(list.size(), 3);
    }
}