package com.example.chessgame;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.chessgame.figures.Figure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Controller {
    private MainActivity mainActivity;
    private Board board = new Board();
    private boolean clicked = false;
    private  boolean check = false;
    private  boolean checkmate = false;
    private View preClicked = null;
    private List<Coordinate> moveList =  new ArrayList<>();  //where clicked figure can move
    private List<Coordinate> moveListCheck = new ArrayList<>();  //where clicked figure can move when is check


    Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Map<Coordinate, Figure> getFigures() {
        return board.getBoardStatus();
    }

    Map<Coordinate, Figure> whatFigureCanMove(Map<Coordinate, Figure> boardStatus) {
        check = board.check();
        moveListCheck.clear();
        AtomicReference<Map<Coordinate, Figure>> temp = new AtomicReference<>(boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().whereCanIMove(boardStatus, e.getKey(), board.whichPlayer()).isEmpty())
                .filter(e -> e.getValue().getColor().equals(board.whichPlayer()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
        Map<Coordinate, Figure> temp2 = new HashMap<>();
        if(check){
            checkmate = false;
            board.getWhoCheck().forEach(coordinate ->{
                Figure figure = board.whatFigureIsThere(coordinate);
                List<Coordinate> unCheckList = (figure.howToUnCheck(boardStatus, coordinate, board.kingCoordinates));
                temp.get().entrySet().forEach(entry ->{
                    List<Coordinate> moveList = entry.getValue().whereCanIMove(boardStatus, entry.getKey(), board.whichPlayer());
                    boolean sameCoordinates = false;
                    //contains ?
                    for(Coordinate coordinate1 : unCheckList) {
                        for (Coordinate coordinate2 : moveList) {
                            if (coordinate1.equals(coordinate2)) {
                                sameCoordinates = true;
                                if(!moveListCheck.contains(coordinate1)) moveListCheck.add(coordinate1);
                            }
                        }
                    }
                    if (sameCoordinates) temp2.put(entry.getKey(), entry.getValue());
                });
                temp.set(temp2);
                if(!temp2.isEmpty()){
                    board.whereKingCanMove();
                    temp.get().put(board.kingCoordinates, board.whatFigureIsThere(board.kingCoordinates));
                }else if(board.getKingMoves().isEmpty()) checkmate = true;

            });
        }

        return temp.get();
    }

    @SuppressLint("SetTextI18n")
    void onClick(View b){
        Map<Coordinate, Figure> figures = getFigures();
        if (!clicked) {
            Figure figure = figures.get(mainActivity.buttons.get(b));
            moveList = figures.get(mainActivity.buttons.get(b)).whereCanIMove(figures, mainActivity.buttons.get(b), board.whichPlayer());
            if(check)
            {
                List<Coordinate> toRemove = new ArrayList<>();
                for(Coordinate c1 : moveList){
                    boolean sameCoordinates = false;
                    for(Coordinate c2 : moveListCheck){
                        if (c1.equals(c2)) {
                            sameCoordinates = true;
                            break;
                        }
                    }
                    if(!sameCoordinates) toRemove.add(c1);
                }
                toRemove.forEach(c -> moveList.remove(c));
                if(figure.getName().equals(FigureName.KING)) moveList = board.getKingMoves();

            }else if (figure != null && figure.getName().equals(FigureName.KING)) {
                board.kingCoordinates = board.whereIsThatFigure(figure);
                moveList = board.getKingMoves();
            }
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
        } else { //if clicked

            for (Object coordinate : moveList) {
                if(mainActivity.buttons.get(b).equals(coordinate)){
                    figures.put(mainActivity.buttons.get(b), figures.get(mainActivity.buttons.get(preClicked)));
                    figures.remove(mainActivity.buttons.get(preClicked));
                    board.changePlayer();
                    Figure figure = figures.get(mainActivity.buttons.get(b));
                    if (figure != null && figure.getName().equals(FigureName.KING))
                        board.kingCoordinates = board.whereIsThatFigure(figure);
                }
            }
            board.setBoardStatus(figures);
            clicked = false;
            preClicked = null;
            mainActivity.update();
            board.addMove();
            if(check) {
                mainActivity.check.setVisibility(View.VISIBLE);
                board.resetWhoCheck();
            }else if(checkmate) {
                mainActivity.check.setVisibility(View.VISIBLE);
                mainActivity.check.setText("checkmate");
                board.resetWhoCheck();
            }
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
