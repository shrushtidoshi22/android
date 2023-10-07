package com.example.dk1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class coworker extends AppCompatActivity {
    EditText mobileemail,pass;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coworker);
        mobileemail=findViewById(R.id.editTextText2);
        pass=findViewById(R.id.editTextTextPassword);
        b1=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobilee = mobileemail.getText().toString();
                String password = pass.getText().toString();
                DbHander1 dbHandler1 = new DbHander1(getApplicationContext());
                dbHandler1.insertloginDetails(mobilee,password);
                Toast.makeText(getApplicationContext(),
                        "Record inserted",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    public void createaccount(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}