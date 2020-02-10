package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Figure {

    FigureName name;
    private FigureColor color;
    private int imageID;

    Figure(FigureColor color, int imageID) {
        this.color = color;
        this.imageID = imageID;
    }


    public List<Coordinate> whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate) {
        return Collections.emptyList();
    }

    public List<Coordinate> howToUnCheck(Map<Coordinate, Figure> map, Coordinate coordinate, Coordinate king) {
        return Collections.emptyList();
    }


    public FigureName getName() {
        return name;
    }

    public FigureColor getColor() {
        return color;
    }

    public int getImageID() {
        return imageID;
    }
}
