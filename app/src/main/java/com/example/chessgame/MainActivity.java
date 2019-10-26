package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import android.appwidget.AppWidgetHostView;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button[][] field = new Button[9][9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void initializeView{
        //field [A-H][1-8]  A=0,B=1,...,H=7
        field[0][1] = findViewById(R.id.A1);
        field[1][1] = findViewById(R.id.B1);
        field[2][1] = findViewById(R.id.C1);
        field[3][1] = findViewById(R.id.D1);
        field[4][1] = findViewById(R.id.E1);
        field[5][1] = findViewById(R.id.F1);
        field[6][1] = findViewById(R.id.G1);
        field[7][1] = findViewById(R.id.H1);
        field[0][2] = findViewById(R.id.A2);
        field[1][2] = findViewById(R.id.B2);
        field[2][2] = findViewById(R.id.C2);
        field[3][2] = findViewById(R.id.D2);
        field[4][2] = findViewById(R.id.E2);
        field[5][2] = findViewById(R.id.F2);
        field[6][2] = findViewById(R.id.G2);
        field[7][2] = findViewById(R.id.H2);
        field[0][3] = findViewById(R.id.A3);
        field[1][3] = findViewById(R.id.B3);
        field[2][3] = findViewById(R.id.C3);
        field[3][3] = findViewById(R.id.D3);
        field[4][3] = findViewById(R.id.E3);
        field[5][3] = findViewById(R.id.F3);
        field[6][3] = findViewById(R.id.G3);
        field[7][3] = findViewById(R.id.H3);
        field[0][4] = findViewById(R.id.A4);
        field[1][4] = findViewById(R.id.B4);
        field[2][4] = findViewById(R.id.C4);
        field[3][4] = findViewById(R.id.D4);
        field[4][4] = findViewById(R.id.E4);
        field[5][4] = findViewById(R.id.F4);
        field[6][4] = findViewById(R.id.G4);
        field[7][4] = findViewById(R.id.H4);
        field[0][5] = findViewById(R.id.A5);
        field[1][5] = findViewById(R.id.B5);
        field[2][5] = findViewById(R.id.C5);
        field[3][5] = findViewById(R.id.D5);
        field[4][5] = findViewById(R.id.E5);
        field[5][5] = findViewById(R.id.F5);
        field[6][5] = findViewById(R.id.G5);
        field[7][5] = findViewById(R.id.H5);
        field[0][6] = findViewById(R.id.A6);
        field[1][6] = findViewById(R.id.B6);
        field[2][6] = findViewById(R.id.C6);
        field[3][6] = findViewById(R.id.D6);
        field[4][6] = findViewById(R.id.E6);
        field[5][6] = findViewById(R.id.F6);
        field[6][6] = findViewById(R.id.G6);
        field[7][6] = findViewById(R.id.H6);
        field[0][7] = findViewById(R.id.A7);
        field[1][7] = findViewById(R.id.B7);
        field[2][7] = findViewById(R.id.C7);
        field[3][7] = findViewById(R.id.D7);
        field[4][7] = findViewById(R.id.E7);
        field[5][7] = findViewById(R.id.F7);
        field[6][7] = findViewById(R.id.G7);
        field[7][7] = findViewById(R.id.H7);
        field[0][8] = findViewById(R.id.A8);
        field[1][8] = findViewById(R.id.B8);
        field[2][8] = findViewById(R.id.C8);
        field[3][8] = findViewById(R.id.D8);
        field[4][8] = findViewById(R.id.E8);
        field[5][8] = findViewById(R.id.F8);
        field[6][8] = findViewById(R.id.G8);
        field[7][8] = findViewById(R.id.H8);
    }



}
