package com.example.connectbd.todo;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.connectbd.R;

public class CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        Button btnCreateTask = findViewById(R.id.addTaskCreate);
        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText TextTitre = findViewById(R.id.addTaskTitle);
                String Titre=TextTitre.getText().toString();
                EditText TextDesc = findViewById(R.id.addTaskDescription);
                String Desc=TextDesc.getText().toString();
                Task t=new Task(Titre,Desc);
                ListTask.GetList().add(t);
                Intent intent = new Intent(getApplicationContext(), Todo.class);
                startActivity(intent);
            }
        });
    }
}