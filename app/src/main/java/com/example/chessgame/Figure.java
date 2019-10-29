package com.example.chessgame;

public abstract class Figure {

    String name;
    String color;

    Figure(String color, String name){
        this.color=color;
        this.name=name;
    }


    void whereCanIMove(){}


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


}
