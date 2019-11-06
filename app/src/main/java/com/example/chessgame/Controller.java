package com.example.chessgame;
import java.util.HashMap;
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

    public Map<Coordinate, Figure> whatFigureCanMove(Map<Coordinate, Figure> boardStatus){
        Map<Coordinate, Figure> whatCanMove = new HashMap<>();

        for(Map.Entry<Coordinate, Figure> coordinateFigureEntry : boardStatus.entrySet()) {
            Figure figure = boardStatus.get(coordinateFigureEntry.getValue());
            if(figure != null && figure.CanIMove(boardStatus, figure.getColor(),coordinateFigureEntry.getKey())) {
                whatCanMove.put(coordinateFigureEntry.getKey(), figure);
            }
        }
        return whatCanMove;

    }
}
