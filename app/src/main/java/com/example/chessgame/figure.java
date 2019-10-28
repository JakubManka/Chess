package com.example.chessgame;

public abstract class figure {

    String name;
    String color;
    int id;

    figure(int id, String color){
        this.color=color;
        this.id=id;
    }

    void whereCanIMove(){}




}
