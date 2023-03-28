package com.example.connectbd.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.connectbd.login.Connexion;
import com.example.connectbd.R;

import java.util.List;

public class Todo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        TextView bv = findViewById(R.id.bienvenue);
        bv.setText("Bonjour "+ Connexion.getName() +" !");
        TextView btnTask = findViewById(R.id.addTaskCreate);
        recyclerView = findViewById(R.id.taskRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //ArrayList<Task> tasks= RequetesBD.getTask(Connexion.getName());
        // Création de la liste de tâches
        //ListTask.setTasks(tasks);
        List<Task> tasks = ListTask.GetList();
        // Création de l'adaptateur pour la liste de tâches
        taskAdapter = new TaskAdapter(this,tasks);
        // Configuration de la RecyclerView avec l'adaptateur
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateTask.class);
                startActivity(intent);
            }
        });
    }
}