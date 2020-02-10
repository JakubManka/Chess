package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.StrictMath.abs;

public class Bishop extends Figure {

    public Bishop(FigureColor color) {
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_bishop : R.drawable.w_bishop);
        this.name = FigureName.BISHOP;
    }

    @Override
    public List<Coordinate> whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate) {
        List<Coordinate> moveList = new ArrayList<>();
        for(int i=1; i<7; i++) {
            Coordinate c = new Coordinate(coordinate.getX()+i, coordinate.getY()+i);
            moveList.add(c);
            if (map.containsKey(c))
                break;
        }

        for(int i=1; i<7; i++) {
            Coordinate c = new Coordinate(coordinate.getX()+i, coordinate.getY()-i);
            moveList.add(c);
            if (map.containsKey(c))
                break;
        }

        for(int i=1; i<7; i++) {
            Coordinate c = new Coordinate(coordinate.getX()-i, coordinate.getY()+i);
            moveList.add(c);
            if (map.containsKey(c))
                break;
        }

        for(int i=1; i<7; i++) {
            Coordinate c = new Coordinate(coordinate.getX()-i, coordinate.getY()-i);
            moveList.add(c);
            if (map.containsKey(c))
                break;
        }

        return moveList.stream()
                .filter(c -> c.getX() > 0 && c.getX() < 9)
                .filter(c -> c.getY() > 0 && c.getY() < 9)
                .filter(c -> map.get(c) == null || !map.get(c).getColor().equals(getColor()))
                .collect(Collectors.toList());

    }

    @Override
    public List<Coordinate> howToUnCheck(Map<Coordinate, Figure> map, Coordinate coordinate, Coordinate king) {
        List<Coordinate> moveList = new ArrayList<>();
        int x = king.x - coordinate.x;
        int y = king.y - coordinate.y;

        if(x > 0 && y > 0) {
            for(int i=0; i<x; i++) moveList.add(new Coordinate(coordinate.x+i, coordinate.y+i));
        }

        if(x > 0 && y < 0) {
            for(int i=0; i<x; i++) moveList.add(new Coordinate(coordinate.x+i, coordinate.y-i));
        }

        if(x < 0 && y > 0) {
            for(int i=0; i<abs(x); i++) moveList.add(new Coordinate(coordinate.x-i, coordinate.y+i));
        }

        if(x < 0 && y < 0) {
            for(int i=0; i<abs(x); i++) moveList.add(new Coordinate(coordinate.x-i, coordinate.y-i));
        }
        return moveList;
    }
}
