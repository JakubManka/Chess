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
    private Pawn pawn = new Pawn(FigureColor.WHITE);
    private Coordinate coordinates;
    private Map<Coordinate, Figure> map = new HashMap<>();

    @Test
    public void ableToMove() {
        coordinates = new Coordinate(1, 1);
        List list = pawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(2, 1)));
        assertEquals(list.size(), 1);
    }

    @Test
    public void notableToMove() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(2, 1), new Pawn(FigureColor.BLACK));
        List list = pawn.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(7, 8)));
        assertTrue("list should be empty", pawn.whereCanIMove(map, coordinates).isEmpty());
    }
}
