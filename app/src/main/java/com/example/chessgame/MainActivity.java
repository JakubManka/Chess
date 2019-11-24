package com.example.chessgame;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chessgame.figures.Figure;
import com.example.chessgame.figures.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.chessgame.Constants.COORDINATES;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Map<Button, Coordinate> buttons = new HashMap<>();
    Button player1Time;
    Button player2Time;
    Button player1Name;
    Button player2Name;



    Controller controller = new Controller(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toast toast = Toast.makeText(getApplicationContext(),
//                "This is a message displayed in a Toast",
//                Toast.LENGTH_SHORT);

        initializeView();


    }



    void initializeView() {
        // i = [A-H] [1-8]
        // j = [1-8] [1-8]
        for (int i = 0; i < COORDINATES.length; i++) {
            for (int j = 0; j < COORDINATES[i].length; j++) {
                Button button = (Button) findViewById(COORDINATES[i][j]);
                button.setOnClickListener(this);
                buttons.put(button, new Coordinate(i + 1, j + 1));
            }
        }
        player1Time = findViewById(R.id.player1time);
        player2Time = findViewById(R.id.player2time);
        player1Name = findViewById(R.id.player1name);
        player2Name = findViewById(R.id.player2name);


        update();
        //time, palyer names, bots, undo
    }

    void update() {

        for (int i = 0; i < COORDINATES.length; i++) {
            for (int j = 0; j < COORDINATES[i].length; j++) {
                Button button = (Button) findViewById(COORDINATES[i][j]);
                button.setClickable(false);
                buttons.put(button, new Coordinate(i + 1, j + 1));

                int m = (j + i % 2) % 2;
                if (m == 0) {
                    button.setBackgroundColor(getResources().getColor(R.color.grey));
                } else if (m == 1) {
                    button.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }
        }

        controller.whatFigureCanMove(controller.getFigures()).keySet().stream()
                .map(this::findButton)
                .forEach(b -> b.setClickable(true));
//                .forEach(b -> b.setBackgroundColor(getResources().getColor(R.color.black)));

        setForeground();
    }

    Button findButton(Coordinate figureCoordinates) {
//        for (Entry<Button, Coordinate> buttonCoordinateEntry : buttons.entrySet()) {
//            if (buttonCoordinateEntry.getValue().equals(figureCoordinates))
//                return buttonCoordinateEntry.getKey();
//        }
//      new RuntimeException("Figure on" + figureCoordinates + " without button !")

        return buttons.entrySet().stream()
                .filter(e -> e.getValue().equals(figureCoordinates))
                .map(Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Figure on" + figureCoordinates + " without button !"));
    }

    void setForeground() {
        buttons.entrySet().forEach(e -> {
            final Figure figure = controller.getFigures().get(e.getValue());
            if (figure != null) {
                e.getKey().setForeground(getDrawable(figure.getImageID()));
            } else e.getKey().setForeground(null);
        });

    }



    @Override
    public void onClick(View b) {
        controller.onClick(b);
    }
}

