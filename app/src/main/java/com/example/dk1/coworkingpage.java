package com.example.dk1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class coworkingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coworkingpage);

    }
    public void book(View view){
        Intent intent = new Intent(this, slot.class);
        startActivity(intent);
    }
    public void meet(View view){
        Intent intent = new Intent(this, slot2.class);
        startActivity(intent);
    }
}