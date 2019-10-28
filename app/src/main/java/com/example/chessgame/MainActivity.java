package com.example.chessgame;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import android.appwidget.AppWidgetHostView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Button[][] fields = new Button[9][9];

//    ArrayList<HashMap<View, figure>> listOfButtons = new ArrayList<>();
    Map<View, figure> buttons = new HashMap<>();

    Controller controller = new Controller(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

    }

//    View.OnClickListenerener(){



    void initializeView(){
        buttons.put(findViewById(R.id.A1,figure = controller.getFigures()));
        buttons.put(findViewById(R.id.A2, ));
        buttons.put(findViewById(R.id.A3, ));
        buttons.put(findViewById(R.id.A4, ));
        buttons.put(findViewById(R.id.A5, ));
        buttons.put(findViewById(R.id.A6, ));
        buttons.put(findViewById(R.id.A7, ));
        buttons.put(findViewById(R.id.A8, ));
        buttons.put(findViewById(R.id.B1, ));

        buttons.put(findViewById(R.id.B1, ));
        buttons.put(findViewById(R.id.B2, ));
        buttons.put(findViewById(R.id.B3, ));
        buttons.put(findViewById(R.id.B4, ));
        buttons.put(findViewById(R.id.B5, ));
        buttons.put(findViewById(R.id.B6, ));
        buttons.put(findViewById(R.id.B7, ));
        buttons.put(findViewById(R.id.B8, ));

        buttons.put(findViewById(R.id.C1, ));
        buttons.put(findViewById(R.id.C2, ));
        buttons.put(findViewById(R.id.C3, ));
        buttons.put(findViewById(R.id.C4, ));
        buttons.put(findViewById(R.id.C5, ));
        buttons.put(findViewById(R.id.C6, ));
        buttons.put(findViewById(R.id.C7, ));
        buttons.put(findViewById(R.id.C8, ));

        buttons.put(findViewById(R.id.D1, ));
        buttons.put(findViewById(R.id.D2, ));
        buttons.put(findViewById(R.id.D3, ));
        buttons.put(findViewById(R.id.D4, ));
        buttons.put(findViewById(R.id.D5, ));
        buttons.put(findViewById(R.id.D6, ));
        buttons.put(findViewById(R.id.D7, ));
        buttons.put(findViewById(R.id.D8, ));

        buttons.put(findViewById(R.id.E1, ));
        buttons.put(findViewById(R.id.E2, ));
        buttons.put(findViewById(R.id.E3, ));
        buttons.put(findViewById(R.id.E4, ));
        buttons.put(findViewById(R.id.E5, ));
        buttons.put(findViewById(R.id.E6, ));
        buttons.put(findViewById(R.id.E7, ));
        buttons.put(findViewById(R.id.E8, ));

        buttons.put(findViewById(R.id.F1, ));
        buttons.put(findViewById(R.id.F2, ));
        buttons.put(findViewById(R.id.F3, ));
        buttons.put(findViewById(R.id.F4, ));
        buttons.put(findViewById(R.id.F5, ));
        buttons.put(findViewById(R.id.F6, ));
        buttons.put(findViewById(R.id.F7, ));
        buttons.put(findViewById(R.id.F8, ));

        buttons.put(findViewById(R.id.G1, ));
        buttons.put(findViewById(R.id.G2, ));
        buttons.put(findViewById(R.id.G3, ));
        buttons.put(findViewById(R.id.G4, ));
        buttons.put(findViewById(R.id.G5, ));
        buttons.put(findViewById(R.id.G6, ));
        buttons.put(findViewById(R.id.G7, ));
        buttons.put(findViewById(R.id.G8, ));

        buttons.put(findViewById(R.id.H1, ));
        buttons.put(findViewById(R.id.H2, ));
        buttons.put(findViewById(R.id.H3, ));
        buttons.put(findViewById(R.id.H4, ));
        buttons.put(findViewById(R.id.H5, ));
        buttons.put(findViewById(R.id.H6, ));
        buttons.put(findViewById(R.id.H7, ));
        buttons.put(findViewById(R.id.H8, ));

        //time, palyer names, bots
    }

    void update(){



    }
    void setForeground(int column, int row, figure figure){
       if(figure.name.equals("bishop"))
    }



}
