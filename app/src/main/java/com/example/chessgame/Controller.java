package com.example.chessgame;

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
    private boolean clicked = false;
    private View preClicked = null;
    private List<Coordinate> moveList =  Collections.emptyList();



    Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Map<Coordinate, Figure> getFigures() {
        return board.getFigures();
    }

    Map<Coordinate, Figure> whatFigureCanMove(Map<Coordinate, Figure> boardStatus) {

        Map<Coordinate, Figure> temp =  boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().whereCanIMove(boardStatus, e.getKey()).isEmpty())
                .filter(e -> e.getValue().getColor().equals(board.whichPlayer()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        Map<Coordinate, Figure> temp2 = temp;
        if(board.check()){
            board.getWhoCheck().forEach(coordinate ->{
                Figure figure = board.whatFigureIsThere(coordinate);
                List<Coordinate> unCheckList = (figure.howToUnCheck(boardStatus, coordinate, board.kingCoordinates));
                temp2.entrySet().forEach(entry ->{
                    List<Coordinate> moveList = entry.getValue().whereCanIMove(boardStatus, entry.getKey());
                    boolean sameCoordinates = false;
                    for(Coordinate coordinate1 : unCheckList) {
                        for (Coordinate coordinate2 : moveList) {
                            if (coordinate1 == coordinate2) {
                                sameCoordinates = true;
                                break;
                            }
                        }
                    }
                    if (!sameCoordinates) temp.remove(entry.getKey());
                });
            });
        }
        return temp;
    }

    void onClick(View b){
        Map<Coordinate, Figure> figures = getFigures();
        if (!clicked) {
            moveList = figures.get(mainActivity.buttons.get(b)).whereCanIMove(figures, mainActivity.buttons.get(b));
//            if(!board.check()){
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
//            }else{


//            }
        } else {
            for (Object coordinate : moveList) {
                if(mainActivity.buttons.get(b).equals(coordinate)){
                    figures.put(mainActivity.buttons.get(b), figures.get(mainActivity.buttons.get(preClicked)));
                    figures.remove(mainActivity.buttons.get(preClicked));
                    board.changePlayer();
                }
            }
            board.setFigures(figures);
            clicked = false;
            preClicked = null;
            mainActivity.update();
            board.addMove();
            if(board.check()) mainActivity.check.setVisibility(View.VISIBLE);
            else mainActivity.check.setVisibility(View.INVISIBLE);
        }
    }

    public void undo() {
        if(board.getAllMoves().size() > 1) {
            board.undoLastMove();
            mainActivity.update();
            board.changePlayer();
            timers();
        }
    }

   public void timers(){
        if(board.whichPlayer().equals(FigureColor.WHITE)){
            mainActivity.start1Timer();
            mainActivity.stopTimer2();
        }else if(board.whichPlayer().equals(FigureColor.BLACK)){
            mainActivity.start2Timer();
            mainActivity.stopTimer1();
        }
    }

    public void reset(){
        board.resetBoard();
        //timers reset
    }

}
