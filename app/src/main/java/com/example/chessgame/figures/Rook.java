package com.example.chessgame.figures;

import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

public class Rook extends Figure {

    public Rook(FigureColor color) {
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_rook : R.drawable.w_rook);
        this.name = FigureName.ROOK;
    }
}
