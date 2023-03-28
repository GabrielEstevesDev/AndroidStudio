package com.example.connectbd.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.connectbd.MainActivity;
import com.example.connectbd.R;
import com.example.connectbd.todo.Todo;
import com.example.connectbd.bd.RequetesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion extends AppCompatActivity {
    private static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        name=null;
        ImageView backConnexion = findViewById(R.id.backConnexion);
        backConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button button = findViewById(R.id.Connexion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textEmail = findViewById(R.id.textEmail);
                String email = textEmail.getText().toString();
                EditText textPassword = findViewById(R.id.textPassword);
                String password = textPassword.getText().toString();
                ResultSet resultSet = RequetesBD.getUser(email,password);
                try {
                    if (resultSet.next()) {
                        name=email;
                        RequetesBD.setTasks(name);
                        Intent intent = new Intent(getApplicationContext(), Todo.class);
                        startActivity(intent);
                    } else {
                        String message = "Erreur : Nom d'utilisateur ou mot de passe incorrect.";
                        // Affichez le message d'erreur en utilisant Toast
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static String getPseudo(){
        return  name;
    }
}