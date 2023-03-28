package com.example.connectbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.connectbd.todo.Todo;
import com.example.connectbd.bd.RequetesBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

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
                        Log.d("user","il existe");
                        Intent intent = new Intent(getApplicationContext(), Todo.class);
                        startActivity(intent);
                    } else {
                        Log.d("user","nonnnnnnnnnnn");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}