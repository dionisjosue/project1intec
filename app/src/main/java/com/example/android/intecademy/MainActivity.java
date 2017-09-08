package com.example.android.intecademy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sh = getSharedPreferences(getPackageName() + Constants.USER_DATA, Context.MODE_PRIVATE);
        Boolean ai = sh.getBoolean(Constants.ALREADY_INTRODUCED, false); //ai - Already introduced
        Boolean ai_part2 = sh.getBoolean(Constants.ALREADY_INTRODUCED_PART2, false); //ai - Already introduced in second part
        if(ai && ai_part2){ //Do not show introduction
            Intent intent = new Intent(this, Start.class);
            startActivity(intent);
        }else if(ai){ //Show part two of introduction
            Intent intent = new Intent(this, Introduce_me_part2.class);
            startActivity(intent);
        }else{ //Show full introduction
            setContentView(R.layout.activity_main);
        }
    }

    public void intrduceMe(View view) {
        Intent intent = new Intent(this, Introduce_me.class);
        startActivity(intent);
    }
}
