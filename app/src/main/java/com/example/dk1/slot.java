package com.example.dk1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class slot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);
    }
    public void next(View view){
        Intent intent = new Intent(this, availableslot.class);
        startActivity(intent);
    }
}