package com.example.chessgame.figures;

import android.graphics.Color;

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

public class Knight extends Figure {

    public Knight(FigureColor color) {
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_knight : R.drawable.w_knight);
        this.name = FigureName.KNIGHT;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate, FigureColor playerColor) {
        List<Coordinate> moveList = new ArrayList<>();
        moveList.add(new Coordinate(coordinate.x + 2, coordinate.y + 1));
        moveList.add(new Coordinate(coordinate.x + 2, coordinate.y - 1));
        moveList.add(new Coordinate(coordinate.x - 2, coordinate.y + 1));
        moveList.add(new Coordinate(coordinate.x - 2, coordinate.y - 1));
        moveList.add(new Coordinate(coordinate.x + 1, coordinate.y + 2));
        moveList.add(new Coordinate(coordinate.x + 1, coordinate.y - 2));
        moveList.add(new Coordinate(coordinate.x - 1, coordinate.y + 2));
        moveList.add(new Coordinate(coordinate.x - 1, coordinate.y - 2));

        return moveList.stream()
                .filter(c -> c.getX() > 0 && c.getX() < 9)
                .filter(c -> c.getY() > 0 && c.getY() < 9)
                .filter(c -> map.get(c) == null || !map.get(c).getColor().equals(getColor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Coordinate> howToUnCheck(Map<Coordinate, Figure> map, Coordinate coordinate, Coordinate king) {
        List<Coordinate> moveList = new ArrayList<>();
        moveList.add(new Coordinate(coordinate.x, coordinate.y));
        return moveList;
    }

}
