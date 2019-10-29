package com.example.chessgame;

public abstract class Figure {

    String name;
    String color;

    Figure(String color){
        this.color=color;
    }


    void whereCanIMove(){}


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


}
