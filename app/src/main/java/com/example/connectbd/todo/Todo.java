package com.example.connectbd.todo;

import static com.example.connectbd.todo.ListTask.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.connectbd.R;

import java.util.ArrayList;

public class Todo extends AppCompatActivity {

    protected static ArrayAdapter<Task> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        TextView btnTask = findViewById(R.id.addTaskCreate);
        ListView l = findViewById(R.id.taskRecycler);
        itemsAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ListTask.GetList());
        ListTask.GetList().setAdapter(itemsAdapter);
        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateTask.class);
                startActivity(intent);
            }
        });
    }
}