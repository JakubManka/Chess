package com.example.chessgame;

import java.util.Map;

public abstract class Figure {

    String name;
    String color;

    Figure(String color){
        this.color=color;
    }


    void whereCanIMove(){}

    boolean CanIMove(Map<Coordinate, Figure> map, String color, Coordinate coordinate){
        return true;
    }


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


}
