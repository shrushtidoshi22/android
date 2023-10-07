package com.example.dk1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, mobile, email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextText);
        mobile = findViewById(R.id.editTextNumberSigned);
        email = findViewById(R.id.editTextTextEmailAddress);
        button = findViewById(R.id.button);
    }
    public void create(View view) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String mobileno = mobile.getText().toString();
                String emailid = email.getText().toString();
                DbHandler dbHandler = new DbHandler(getApplicationContext());
                dbHandler.insertUserDetails(username, mobileno, emailid);
                Toast.makeText(getApplicationContext(),
                        "Record inserted",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    public void login(View view){
        Intent intent = new Intent(this, coworker.class);
        startActivity(intent);
    }
}