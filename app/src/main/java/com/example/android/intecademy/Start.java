package com.example.android.intecademy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 8/26/2017.
 */

public class Start extends AppCompatActivity {

    float gi; //indice general
    int tc; //total creditos
    float tp; //total de puntos  = TOTAL_CREDITOS * IG
    int it; //indice trimestral = TOTAL_PUNTOS / TOTAL_CREDITOS

    //Nuvos valores
    int new_ig; // (tp_anteriores + tp_trimestreActual) / (tc_anteriores + tc_trimestreActual)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        //Initialize Global Variables

        //Execute firsts actions
        SharedPreferences sh = getSharedPreferences(getPackageName() + Constants.USER_DATA, Context.MODE_PRIVATE);
        gi = Float.parseFloat(sh.getString(Constants.USER_GENERAL_INDEX,"0"));
        tc = Integer.parseInt(sh.getString(Constants.USER_TOTAL_CREDITS,"0"));
        //Calculations
        tp = round(gi * tc, 2);
        TextView total_points = (TextView)findViewById(R.id.totalPoints);
        total_points.setText(Float.toString(tp));

        //Call to functions

    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public void projectIndex(View view) {
        Intent intent = new Intent(this, ProjectIndex.class);
        startActivity(intent);
    }
}
