package com.example.chessgame;
import java.util.Map;

public class Controller {
    private MainActivity mainActivity;
    private Board board = new Board();


    Controller(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    public Map<Coordinate, Figure> getFigures()
    {
        return board.getFigures();
    }


}
