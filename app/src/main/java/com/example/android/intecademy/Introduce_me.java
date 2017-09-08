package com.example.android.intecademy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

/**
 * Created by USER on 8/26/2017.
 */

public class Introduce_me extends AppCompatActivity {

    AutoCompleteTextView actvName;
    AutoCompleteTextView actvId;
    Spinner careers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_introduce);

        //Initialize global variables
        careers = (Spinner)findViewById(R.id.sCareer);
        actvName = (AutoCompleteTextView)findViewById(R.id.actvNames);
        actvId = (AutoCompleteTextView)findViewById(R.id.actvId);

        //Start first actions
        careers.setPrompt("Seleccione un programa");
    }

    public void saveUserData(View view) { //Record user data persistently - SharedPreferences
        if(validateIntroduction()){
            SharedPreferences sh = getSharedPreferences(getPackageName() + Constants.USER_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sh.edit();
            e.putString(Constants.USER_FULLNAME, actvName.getText().toString());
            e.putString(Constants.USER_ID, actvId.getText().toString());
            e.putString(Constants.USER_CAREER, careers.getSelectedItem().toString());
            e.putBoolean(Constants.ALREADY_INTRODUCED, true);
            e.apply();

            secondIntroduction();

        }else{
            //Show error
        }
    }
    private boolean validateIntroduction(){ //Simple validation
        if(actvName.getText().toString().equals("")||actvId.getText().toString().equals("")||careers.getSelectedItem().toString().equals("")){
            return false;
        }else{
            return true;
        }
    }
    private void secondIntroduction(){
        Intent intent = new Intent(this, Introduce_me_part2.class);
        startActivity(intent);
    }
}
