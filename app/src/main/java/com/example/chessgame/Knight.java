package com.example.chessgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knight extends Figure {

    Knight(String color){
            super(color);
        this.name="knight";
    }

    @Override
    boolean CanIMove(Map<Coordinate, Figure> map, String color, Coordinate knightCoordinate) {
        List<Coordinate> moveList = new ArrayList<>();
        moveList.add(0, new Coordinate(knightCoordinate.x + 2, knightCoordinate.y + 1));
        moveList.add(1, new Coordinate(knightCoordinate.x + 2, knightCoordinate.y - 1));
        moveList.add(2, new Coordinate(knightCoordinate.x - 2, knightCoordinate.y + 1));
        moveList.add(3, new Coordinate(knightCoordinate.x - 2, knightCoordinate.y - 1));
        moveList.add(4, new Coordinate(knightCoordinate.x + 1, knightCoordinate.y + 2));
        moveList.add(5, new Coordinate(knightCoordinate.x + 1, knightCoordinate.y - 2));
        moveList.add(6, new Coordinate(knightCoordinate.x - 1, knightCoordinate.y + 2));
        moveList.add(7, new Coordinate(knightCoordinate.x - 1, knightCoordinate.y - 2));

        for(int i=0; i<moveList.size(); i++) {
            for(Map.Entry<Coordinate, Figure> coordinateFigureEntry : map.entrySet()){
                if(coordinateFigureEntry.getKey()==moveList.get(i)){
                    Figure figure = coordinateFigureEntry.getValue();
                    if(!figure.getColor().equals(color)) return true;
                }else if(moveList.get(i).getX() > 0 && moveList.get(i).getX() < 9 &&
                        moveList.get(i).getY() > 0 && moveList.get(i).getY() <9) return true;
            }

        }
        return false;
    }


}
