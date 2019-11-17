package com.example.chessgame;

import android.util.Log;

import com.example.chessgame.figures.Figure;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Controller {
    private MainActivity mainActivity;
    private Board board = new Board();


    Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Map<Coordinate, Figure> getFigures() {
        return board.getFigures();
    }

    public Map<Coordinate, Figure> whatFigureCanMove(Map<Coordinate, Figure> boardStatus) {
//        Map<Coordinate, Figure> whatCanMove = new HashMap<>();
//
//        for(Map.Entry<Coordinate, Figure> coordinateFigureEntry : boardStatus.entrySet()) {
//            Figure figure = coordinateFigureEntry.getValue();
//            if(figure != null && !figure.whereCanIMove(boardStatus, coordinateFigureEntry.getKey()).isEmpty()) {
//                whatCanMove.put(coordinateFigureEntry.getKey(), figure);
//            }
//        }
        return boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().whereCanIMove(boardStatus, e.getKey()).isEmpty())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public void setFigures(Map<Coordinate, Figure> figures) {
        board.setFigures(figures);
    }
}
