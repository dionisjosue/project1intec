package com.example.android.intecademy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by USER on 8/26/2017.
 */

public class Success extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
    }

    public void start(View view) {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);

    }
}
