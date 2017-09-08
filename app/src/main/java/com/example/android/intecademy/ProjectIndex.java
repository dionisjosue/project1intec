package com.example.android.intecademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProjectIndex extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_index);
        list = (ListView)findViewById(R.id.list);

        ArrayList<String> spool = new ArrayList<String>();
        spool.add("Pruba 1");
        spool.add("Pruba 1");
        spool.add("Pruba 1");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.subject_info, spool);
        list.setAdapter(adapter);
    }

    public void addSubject(View view) {
        Intent intent = new Intent(this, AddSubject.class);
        startActivity(intent);
    }
}
