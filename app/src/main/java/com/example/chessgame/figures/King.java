package com.example.chessgame.figures;

import com.example.chessgame.FigureColor;
import com.example.chessgame.FigureName;
import com.example.chessgame.R;
import com.example.chessgame.figures.Figure;

public class King extends Figure {


    public King(FigureColor color){
        super(color, color.equals(FigureColor.BLACK) ? R.drawable.b_king : R.drawable.w_king);
        this.name= FigureName.KING;
    }
}
