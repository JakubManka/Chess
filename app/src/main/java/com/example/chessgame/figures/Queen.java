package com.example.chessgame.figures;

import com.example.chessgame.Constants;
import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.StrictMath.abs;

public class Queen extends Figure {

    public Queen(FigureColor color){
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_queen : R.drawable.w_queen);
        this.name= FigureName.QUEEN;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate) {
        List<Coordinate> moveList = new ArrayList<>();
        for (int y = coordinate.getY()+1; y < 9; y++) {
            Coordinate c = new Coordinate(coordinate.getX(), y);
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }
        for (int y = coordinate.getY()-1; y > 0; y--) {
            Coordinate c = new Coordinate(coordinate.getX(), y);
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }
        for (int x = coordinate.getX()+1; x < 9; x++) {
            Coordinate c = new Coordinate(x, coordinate.getY());
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }
        for (int x = coordinate.getX()-1; x > 0; x--) {
            Coordinate c = new Coordinate(x, coordinate.getY());
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }

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

        if(x > 0 && y == 0) {
            for(int i=0; i<x; i++) moveList.add(new Coordinate(coordinate.x+i, coordinate.y));
        }

        if(x < 0 && y == 0) {
            for(int i=0; i<abs(x); i++) moveList.add(new Coordinate(coordinate.x-i, coordinate.y));
        }

        if(x == 0 && y > 0) {
            for(int i=0; i<y; i++) moveList.add(new Coordinate(coordinate.x, coordinate.y+1));
        }

        if(x == 0 && y < 0) {
            for(int i=0; i<abs(y); i++) moveList.add(new Coordinate(coordinate.x, coordinate.y-1));
        }

        return moveList;
    }

}
