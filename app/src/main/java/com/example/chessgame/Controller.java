package com.example.chessgame;

import android.util.Log;
import android.view.View;

import com.example.chessgame.figures.Figure;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Controller {
    private MainActivity mainActivity;
    private Board board = new Board();
    boolean clicked = false;
    View preClicked = null;
    List<Coordinate> moveList =  Collections.emptyList();



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
                .filter(e -> e.getValue().getColor().equals(board.whichPlayer()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public void setFigures(Map<Coordinate, Figure> figures) {
        board.setFigures(figures);
    }

    public void onClick(View b){
        Map<Coordinate, Figure> figures = getFigures();
        if (!clicked) {
            moveList = figures.get(mainActivity.buttons.get(b)).whereCanIMove(figures, mainActivity.buttons.get(b));
            for (Object coordinate : moveList) {
                mainActivity.buttons.entrySet().stream()
                        .filter(bu -> bu.getValue().equals(coordinate))
                        .forEach(bu -> {
                            bu.getKey().setClickable(true);
                            bu.getKey().setBackgroundColor(mainActivity.getResources().getColor(R.color.blue));
                            mainActivity.buttons.put(bu.getKey(), bu.getValue());
                            clicked = true;
                        });
                preClicked = b;
            }
        } else {
            for (Object coordinate : moveList) {
                if(mainActivity.buttons.get(b).equals(coordinate)){
                    figures.put(mainActivity.buttons.get(b), figures.get(mainActivity.buttons.get(preClicked)));
                    figures.remove(mainActivity.buttons.get(preClicked));
                    board.changePlayer();
                }
            }
            setFigures(figures);
            clicked = false;
            preClicked = null;
            mainActivity.update();
        }
    }

//    public FigureColor whichPlayer(){
//        return board.whichPlayer();
//    }
}
