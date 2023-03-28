package com.example.connectbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.connectbd.bd.RequetesBD;

import java.sql.ResultSet;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Button button = findViewById(R.id.btnInsp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textmail =findViewById(R.id.editTextEmail);
                String email = textmail.getText().toString();
                EditText textpseudo=findViewById(R.id.editTextPseudo);
                String pseudo = textpseudo.getText().toString();
                EditText textPassword = findViewById(R.id.editTextPassword);
                String password = textPassword.getText().toString();
                if(RequetesBD.insertUser(email,pseudo,password)){
                    Intent intent = new Intent(getApplicationContext(), Connexion.class);
                    startActivity(intent);
                }
            }
        });
    }
}