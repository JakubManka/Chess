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

public class Queen extends Figure {

    public Queen(FigureColor color){
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_queen : R.drawable.w_queen);
        this.name= FigureName.QUEEN;
    }

    @Override
    public List whereCanIMove(Map<Coordinate, Figure> map, Coordinate queenCoordinate) {
        List<Coordinate> moveList = new ArrayList<>();
        for (int y = queenCoordinate.getY()+1; y < 9; y++) {
            Coordinate c = new Coordinate(queenCoordinate.getX(), y);
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }
        for (int y = queenCoordinate.getY()-1; y > 0; y--) {
            Coordinate c = new Coordinate(queenCoordinate.getX(), y);
            moveList.add(c);
            if(map.containsKey(c))
                break;
        }

        for(int i=1; i<7; i++) {
            Coordinate c = new Coordinate(queenCoordinate.getX()+i, queenCoordinate.getY()+i);
            moveList.add(c);
            if (map.containsKey(c))
                break;
        }

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
