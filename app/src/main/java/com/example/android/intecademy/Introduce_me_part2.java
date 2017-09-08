package com.example.android.intecademy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;

/**
 * Created by USER on 8/26/2017.
 */

public class Introduce_me_part2 extends AppCompatActivity {

    AutoCompleteTextView generalIndex;
    AutoCompleteTextView totalCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_introduce2);
        //Initialize variables
        generalIndex = (AutoCompleteTextView)findViewById(R.id.actvIndiceGeeneral);
        totalCredits = (AutoCompleteTextView)findViewById(R.id.actvTotalCreditos);
    }

    public void btnContinue(View view) {
        Intent intent = new Intent(this, Success.class);
        saveData(view);
        startActivity(intent);
    }

    public void saveData(View view) { //Record user data persistently - SharedPreferences
        if(validateIntroduction()){
            SharedPreferences sh = getSharedPreferences(getPackageName() + Constants.USER_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sh.edit();
            e.putString(Constants.USER_GENERAL_INDEX, generalIndex.getText().toString());
            e.putString(Constants.USER_TOTAL_CREDITS, totalCredits.getText().toString());
            e.putBoolean(Constants.ALREADY_INTRODUCED_PART2, true);
            e.apply();
        }else{
            //Show error
        }
    }
    private boolean validateIntroduction(){ //Simple validation
        if(generalIndex.getText().toString().equals("")||totalCredits.getText().toString().equals("")){
            return false;
        }else{
            return true;
        }
    }
}
