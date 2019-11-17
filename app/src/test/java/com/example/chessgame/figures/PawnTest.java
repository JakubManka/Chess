package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PawnTest {
    private Pawn whitePawn = new Pawn(FigureColor.WHITE);
    private Pawn blackPawn = new Pawn(FigureColor.BLACK);
    private Coordinate coordinates;
    private Map<Coordinate, Figure> map = new HashMap<>();

    @Test
    public void whiteAbleToMove() {
        coordinates = new Coordinate(1, 4);
        List list = whitePawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(2, 4)));
        assertEquals(list.size(), 1);
    }
    @Test
    public void blackAbleToMove() {
        coordinates = new Coordinate(8, 8);
        List list = blackPawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(7, 8)));
        assertEquals(list.size(), 1);
    }

    @Test
    public void notableToMove() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(2, 1), new Pawn(FigureColor.BLACK));
        List list = whitePawn.whereCanIMove(map, coordinates);
        assertTrue("list should be empty", whitePawn.whereCanIMove(map, coordinates).isEmpty());
    }

    @Test
    public void whiteAbleToHit() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(2, 2), new Pawn(FigureColor.BLACK));
        List list = whitePawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(2, 2)));
        assertTrue(list.contains(new Coordinate(2, 1)));
        assertEquals(list.size(), 2);
    }

    @Test
    public void blackAbleToHit() {
        coordinates = new Coordinate(8, 8);
        map.put(new Coordinate(7, 7), new Pawn(FigureColor.WHITE));
        List list = blackPawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(7, 7)));
        assertTrue(list.contains(new Coordinate(7, 8)));
        assertEquals(list.size(), 2);
    }
}

