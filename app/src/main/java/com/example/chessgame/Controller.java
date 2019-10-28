package com.example.chessgame;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private MainActivity mainActivity;
    private Model model;


    Controller(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    public Map getFigures()
    {
        return model.getFigures();
    }


}
