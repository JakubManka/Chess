package com.example.chessgame.figures;

import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

public class Bishop extends Figure {

    public Bishop(FigureColor color) {
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_bishop : R.drawable.w_bishop);
        this.name = FigureName.BISHOP;
    }
}
