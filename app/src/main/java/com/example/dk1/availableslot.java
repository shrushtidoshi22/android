package com.example.dk1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class availableslot extends AppCompatActivity {
    GridView gridview;

    String arr[] = new String[40];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availableslot);
        gridview = findViewById(R.id.gridview);

        for (int i = 0; i < 40; i++) {

            arr[i] = Integer.toString(i + 1);

        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.btn, arr);
        gridview.setAdapter(ad);

    }
}