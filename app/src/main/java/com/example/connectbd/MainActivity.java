package com.example.connectbd;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.connectbd.login.Connexion;
import com.example.connectbd.login.Inscription;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(threadPolicy);
       /* try {
            Connection bd = getConnexion();
            String selectSql = "SELECT * FROM utilisateurs";
            PreparedStatement statement = null;
            statement = bd.prepareStatement(selectSql);
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Log.d("tag",resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        Button button = findViewById(R.id.btnConnexion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Connexion.class);
                startActivity(intent);
            }
        });
        Button btn = findViewById(R.id.btnInscription);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inscription.class);
                startActivity(intent);
            }
        });



    }
}