package com.example.chessgame;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



//    ArrayList<HashMap<View, figure>> listOfButtons = new ArrayList<>();
    Map<Button, Coordinate> buttons = new HashMap<>();

    Controller controller = new Controller(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toast toast = Toast.makeText(getApplicationContext(),
//                "This is a message displayed in a Toast",
//                Toast.LENGTH_SHORT);

        initializeView();
        setForeground();



    }

//    View.OnClickListenerener(){



    void initializeView(){
        // x = [A-H] [1-8]
        // y = [1-8] [1-8]
        buttons.put ((Button) findViewById(R.id.A1),(new Coordinate(1,1)));
        buttons.put ((Button) findViewById(R.id.A2),(new Coordinate(1,2)));
        buttons.put ((Button) findViewById(R.id.A3),(new Coordinate(1,3)));
        buttons.put ((Button) findViewById(R.id.A4),(new Coordinate(1,4)));
        buttons.put ((Button) findViewById(R.id.A5),(new Coordinate(1,5)));
        buttons.put ((Button) findViewById(R.id.A6),(new Coordinate(1,6)));
        buttons.put ((Button) findViewById(R.id.A7),(new Coordinate(1,7)));
        buttons.put ((Button) findViewById(R.id.A8),(new Coordinate(1,8)));

        buttons.put ((Button) findViewById(R.id.B1),(new Coordinate(2,1)));
        buttons.put ((Button) findViewById(R.id.B2),(new Coordinate(2,2)));
        buttons.put ((Button) findViewById(R.id.B3),(new Coordinate(2,3)));
        buttons.put ((Button) findViewById(R.id.B4),(new Coordinate(2,4)));
        buttons.put ((Button) findViewById(R.id.B5),(new Coordinate(2,5)));
        buttons.put ((Button) findViewById(R.id.B6),(new Coordinate(2,6)));
        buttons.put ((Button) findViewById(R.id.B7),(new Coordinate(2,7)));
        buttons.put ((Button) findViewById(R.id.B8),(new Coordinate(2,8)));

        buttons.put ((Button) findViewById(R.id.C1),(new Coordinate(3,1)));
        buttons.put ((Button) findViewById(R.id.C2),(new Coordinate(3,2)));
        buttons.put ((Button) findViewById(R.id.C3),(new Coordinate(3,3)));
        buttons.put ((Button) findViewById(R.id.C4),(new Coordinate(3,4)));
        buttons.put ((Button) findViewById(R.id.C5),(new Coordinate(3,5)));
        buttons.put ((Button) findViewById(R.id.C6),(new Coordinate(3,6)));
        buttons.put ((Button) findViewById(R.id.C7),(new Coordinate(3,7)));
        buttons.put ((Button) findViewById(R.id.C8),(new Coordinate(3,8)));

        buttons.put ((Button) findViewById(R.id.D1),(new Coordinate(4,1)));
        buttons.put ((Button) findViewById(R.id.D2),(new Coordinate(4,2)));
        buttons.put ((Button) findViewById(R.id.D3),(new Coordinate(4,3)));
        buttons.put ((Button) findViewById(R.id.D4),(new Coordinate(4,4)));
        buttons.put ((Button) findViewById(R.id.D5),(new Coordinate(4,5)));
        buttons.put ((Button) findViewById(R.id.D6),(new Coordinate(4,6)));
        buttons.put ((Button) findViewById(R.id.D7),(new Coordinate(4,7)));
        buttons.put ((Button) findViewById(R.id.D8),(new Coordinate(4,8)));

        buttons.put ((Button) findViewById(R.id.E1),(new Coordinate(5,1)));
        buttons.put ((Button) findViewById(R.id.E2),(new Coordinate(5,2)));
        buttons.put ((Button) findViewById(R.id.E3),(new Coordinate(5,3)));
        buttons.put ((Button) findViewById(R.id.E4),(new Coordinate(5,4)));
        buttons.put ((Button) findViewById(R.id.E5),(new Coordinate(5,5)));
        buttons.put ((Button) findViewById(R.id.E6),(new Coordinate(5,6)));
        buttons.put ((Button) findViewById(R.id.E7),(new Coordinate(5,7)));
        buttons.put ((Button) findViewById(R.id.E8),(new Coordinate(5,8)));

        buttons.put ((Button) findViewById(R.id.F1),(new Coordinate(6,1)));
        buttons.put ((Button) findViewById(R.id.F2),(new Coordinate(6,2)));
        buttons.put ((Button) findViewById(R.id.F3),(new Coordinate(6,3)));
        buttons.put ((Button) findViewById(R.id.F4),(new Coordinate(6,4)));
        buttons.put ((Button) findViewById(R.id.F5),(new Coordinate(6,5)));
        buttons.put ((Button) findViewById(R.id.F6),(new Coordinate(6,6)));
        buttons.put ((Button) findViewById(R.id.F7),(new Coordinate(6,7)));
        buttons.put ((Button) findViewById(R.id.F8),(new Coordinate(6,8)));

        buttons.put ((Button) findViewById(R.id.G1),(new Coordinate(7,1)));
        buttons.put ((Button) findViewById(R.id.G2),(new Coordinate(7,2)));
        buttons.put ((Button) findViewById(R.id.G3),(new Coordinate(7,3)));
        buttons.put ((Button) findViewById(R.id.G4),(new Coordinate(7,4)));
        buttons.put ((Button) findViewById(R.id.G5),(new Coordinate(7,5)));
        buttons.put ((Button) findViewById(R.id.G6),(new Coordinate(7,6)));
        buttons.put ((Button) findViewById(R.id.G7),(new Coordinate(7,7)));
        buttons.put ((Button) findViewById(R.id.G8),(new Coordinate(7,8)));

        buttons.put ((Button) findViewById(R.id.H1),(new Coordinate(8,1)));
        buttons.put ((Button) findViewById(R.id.H2),(new Coordinate(8,2)));
        buttons.put ((Button) findViewById(R.id.H3),(new Coordinate(8,3)));
        buttons.put ((Button) findViewById(R.id.H4),(new Coordinate(8,4)));
        buttons.put ((Button) findViewById(R.id.H5),(new Coordinate(8,5)));
        buttons.put ((Button) findViewById(R.id.H6),(new Coordinate(8,6)));
        buttons.put ((Button) findViewById(R.id.H7),(new Coordinate(8,7)));
        buttons.put ((Button) findViewById(R.id.H8),(new Coordinate(8,8)));

        //time, palyer names, bots
    }

    void update(){



    }
    void setForeground(){
        for (Map.Entry<Button, Coordinate> buttonCoordinateEntry : buttons.entrySet()) {
            final Figure figure = controller.getFigures().get(buttonCoordinateEntry.getValue());
//            buttonCoordinateEntry.getKey().setForeground(getDrawable(R.drawable.b_pawn));
            if (figure != null && figure.getColor().equals("Black")){
//                if(figure.getName().equals("pawn")) buttonCoordinateEntry.getKey().setForeground(getDrawable(R.drawable.b_pawn));
                switch (figure.getName()) {
                    case "pawn":
                        buttonCoordinateEntry.getKey().setForeground(getDrawable(R.drawable.b_pawn));
                        break;

                    case "knight":
                        buttonCoordinateEntry.getKey().setForeground(getDrawable(R.drawable.b_knight));
                        break;

                }

            }

        }


    }



}
