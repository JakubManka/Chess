package com.example.chessgame.figures;

import com.example.chessgame.Coordinate;
import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pawn extends Figure {

    public Pawn(FigureColor color){
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_pawn : R.drawable.w_pawn);
        this.name= FigureName.PAWN;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate pawnCoordinate) {
        List<Coordinate> moveList = new ArrayList<>();



        for (Coordinate move : moveList) {
            for (Map.Entry<Coordinate, Figure> coordinateFigureEntry : map.entrySet()) {
                if (coordinateFigureEntry.getKey() == move) {
                    Figure figure = coordinateFigureEntry.getValue();
                    if(figure.getColor().equals(getColor())){
                        moveList.remove(move);
                    }
                }
            }
        }
        return moveList;
    }

}
