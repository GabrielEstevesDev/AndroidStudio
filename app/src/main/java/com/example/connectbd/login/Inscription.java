package com.example.connectbd.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.connectbd.main.MainActivity;
import com.example.connectbd.R;
import com.example.connectbd.bd.RequetesBD;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        ImageView backConnexion = findViewById(R.id.backInscription);
        backConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button button = findViewById(R.id.btnInsp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textmail =findViewById(R.id.editTextEmail);
                String email = textmail.getText().toString().trim();
                EditText textpseudo=findViewById(R.id.editTextPseudo);
                String pseudo = textpseudo.getText().toString().trim();
                EditText textPassword = findViewById(R.id.editTextPassword);
                String password = textPassword.getText().toString().trim();
                if(password.length()==0 || pseudo.length()==0 || email.length()==0){
                    String message = "Erreur : Veuillez remplir tous les champs nécessaires.";
                    // Affichez le message d'erreur en utilisant Toast
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
                else {
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

            }
        });
    }
}