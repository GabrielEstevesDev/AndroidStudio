package com.example.connectbd.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.connectbd.R;
import com.example.connectbd.bd.RequetesBD;
import com.example.connectbd.login.Connexion;

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
                String email = textmail.getText().toString().trim();
                EditText textpseudo=findViewById(R.id.editTextPseudo);
                String pseudo = textpseudo.getText().toString().trim();
                pseudo = pseudo.substring(0, 1).toUpperCase() + pseudo.substring(1).toLowerCase();
                EditText textPassword = findViewById(R.id.editTextPassword);
                String password = textPassword.getText().toString().trim();
                if(RequetesBD.insertUser(email,pseudo,password)){
                    Intent intent = new Intent(getApplicationContext(), Connexion.class);
                    startActivity(intent);
                }
                else{
                    String message = "Erreur : Nom d'utilisateur déjà existant.";
                    // Affichez le message d'erreur en utilisant Toast
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}