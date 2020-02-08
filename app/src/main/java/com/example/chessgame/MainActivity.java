package com.example.chessgame;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chessgame.figures.Figure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
    Button undo;
    Button menu;

    private long time1 = TIME_IN_MILLIS;
    private long time2 = TIME_IN_MILLIS;

    boolean timer1Run;
    boolean timer2Run;


    private CountDownTimer timer1;
    private CountDownTimer timer2;
    private String player1TimeS = String.format(Locale.getDefault(), "%02d:%02d", 10, 0);
    private String player2TimeS = String.format(Locale.getDefault(), "%02d:%02d", 10, 0);
    private static final long TIME_IN_MILLIS = 600000;

    Controller controller = new Controller(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        Toast toast = Toast.makeText(getApplicationContext(),
//                "This is a message displayed in a Toast",
//                Toast.LENGTH_SHORT);

        initializeView();
        undo();
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
        undo = findViewById(R.id.undo);
        menu = findViewById(R.id.menu);

        undo.setForeground(getDrawable(R.drawable.undo));
        menu.setForeground(getDrawable(R.drawable.menu));

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
        setForeground();
        controller.timers();
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

    public void undo() {
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.undo();
                update();
            }
        });
    }

    void start1Timer() {
        timer1 = new CountDownTimer(time1, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time1 = millisUntilFinished;
                update1Timer();
                timer1Run = true;
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    void start2Timer() {
        timer2 = new CountDownTimer(time2, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time2 = millisUntilFinished;
                update2Timer();
                timer2Run = true;
            }

            @Override
            public void onFinish() {
            }

        }.start();
    }

    private void update1Timer() {
        int minutes = (int) (time1 / 1000) / 60;
        int seconds = (int) (time1 / 1000) % 60;

        player1TimeS = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        player1Time.setText(player1TimeS);
    }

    private void update2Timer() {
        int minutes = (int) (time2 / 1000) / 60;
        int seconds = (int) (time2 / 1000) % 60;

        player2TimeS = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        player2Time.setText(player2TimeS);
    }

    void stopTimer1() {
        if (timer1Run) timer1.cancel();
    }

    void stopTimer2() {
        if(timer2Run) timer2.cancel();
    }

    @Override
    public void onClick(View b) {
        controller.onClick(b);
    }


}

