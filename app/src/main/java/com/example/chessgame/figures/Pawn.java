package com.example.chessgame.figures;

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

    public Pawn(FigureColor color){
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_pawn : R.drawable.w_pawn);
        this.name= FigureName.PAWN;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate coordinate) {
        List<Coordinate> moveList = new ArrayList<>();
        if(getColor().equals(FigureColor.BLACK))
        {
            moveList.add(new Coordinate(coordinate.x - 1, coordinate.y + 1));
            moveList.add(new Coordinate(coordinate.x - 1, coordinate.y - 1));
            moveList.add(new Coordinate(coordinate.x - 1, coordinate.y));

        }else {
            moveList.add(new Coordinate(coordinate.x + 1, coordinate.y + 1));
            moveList.add(new Coordinate(coordinate.x + 1, coordinate.y - 1));
            moveList.add(new Coordinate(coordinate.x + 1, coordinate.y));
        }




    }


}
