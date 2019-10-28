package com.example.chessgame;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {


    private Map<String,Map<Integer, figure>> colors = new HashMap<>();
    private Map<Integer, figure> whiteFigures = new HashMap<>();
    private Map<Integer, figure> blackFigures = new HashMap<>();
    private int player1Time;
    private int player2Time;


    Model(){

        whiteFigures.put(0, new pawn(0,"white"));
        whiteFigures.put(1, new pawn(1,"white"));
        whiteFigures.put(2, new pawn(2,"white"));
        whiteFigures.put(3, new pawn(3,"white"));
        whiteFigures.put(4, new pawn(4,"white"));
        whiteFigures.put(5, new pawn(5,"white"));
        whiteFigures.put(6, new pawn(6,"white"));
        whiteFigures.put(7, new pawn(7,"white"));

        blackFigures.put(0, new pawn(8,"black"));
        blackFigures.put(1, new pawn(9,"black"));
        blackFigures.put(2, new pawn(10,"black"));
        blackFigures.put(3, new pawn(11,"black"));
        blackFigures.put(4, new pawn(12,"black"));
        blackFigures.put(5, new pawn(13,"black"));
        blackFigures.put(6, new pawn(14,"black"));
        blackFigures.put(7, new pawn(15,"black"));

        colors.put("white", whiteFigures);
        colors.put("black", blackFigures);


    }


    public Map getFigures(){
        return colors;
    }



}
