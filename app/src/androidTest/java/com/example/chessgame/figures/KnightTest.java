package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KnightTest {
    Knight knight = new Knight(FigureColor.BLACK);
    private Coordinate coordinates;
    private Map<Coordinate, Figure> map = new HashMap<>();


    @Test
    public void notAbleToMove() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(3, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 3), new Pawn(FigureColor.BLACK));
        assertTrue("list should be empty", knight.whereCanIMove(map, coordinates).isEmpty());
    }

    @Test
    public void ableToMove() {
        coordinates = new Coordinate(1, 1);
        List list = knight.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(3, 2)));
        assertTrue(list.contains(new Coordinate(2, 3)));
        assertEquals(list.size(), 2);
    }

    @Test
    public void ableToHitPawn() {
        coordinates = new Coordinate(1, 1);
        map.put(new Coordinate(3, 2), new Pawn(FigureColor.BLACK));
        map.put(new Coordinate(2, 3), new Pawn(FigureColor.WHITE));
        List list = knight.whereCanIMove(map, coordinates);
        assertTrue(list.contains(new Coordinate(2, 3)));
        assertEquals(list.size(), 1);
    }
}