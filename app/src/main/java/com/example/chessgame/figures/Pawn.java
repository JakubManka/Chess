package com.example.chessgame.figures;

import android.graphics.Color;

import com.example.chessgame.Constants;
import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends Figure {

    public Pawn(FigureColor color) {
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_pawn : R.drawable.w_pawn);
        this.name = FigureName.PAWN;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate, FigureColor playerColor) {
        List<Coordinate> moveList = new ArrayList<>();
        int move = 0;
        if (getColor().equals(FigureColor.BLACK)) {
            move = -1;
        } else if (getColor().equals(FigureColor.WHITE)) move = 1;

        Coordinate co = new Coordinate(coordinate.x + move, coordinate.y);

        moveList.add(new Coordinate(coordinate.x + move, coordinate.y + 1));
        moveList.add(new Coordinate(coordinate.x + move, coordinate.y - 1));
        List<Coordinate> moves = new ArrayList<>();
        moves = moveList.stream()
                .filter(c -> map.get(c) != null)
                .filter(c -> !map.get(c).getColor().equals(getColor()))
                .collect(Collectors.toList());

        if (getColor().equals(playerColor)){
            if (map.get(co) == null) moves.add(co);
        }else {
            moves.add(new Coordinate(coordinate.x + move, coordinate.y + 1));
            moves.add(new Coordinate(coordinate.x + move, coordinate.y - 1));
        }
        if ((coordinate.x == 2 || coordinate.x == 7) && map.get(new Coordinate(co.x + move, co.y)) == null)
            moves.add(new Coordinate(co.x + move, co.y));

        return moves;

    }

    @Override
    public List<Coordinate> howToUnCheck(Map<Coordinate, Figure> map, Coordinate coordinate, Coordinate king) {
        List<Coordinate> moveList = new ArrayList<>();
        moveList.add(new Coordinate(coordinate.x, coordinate.y));
        return moveList;
    }

}



