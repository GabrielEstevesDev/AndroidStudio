package com.example.connectbd.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.connectbd.login.Connexion;
import com.example.connectbd.R;
import com.example.connectbd.bd.RequetesBD;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private static List<Task> tasks;
    private Context context;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.titleTextView.setText(task.getTitre());
        holder.descTextView.setText(task.getDesc());
        //holder.imgOptions.setOnClickListener(view -> showPopUpMenu(view, position));
    }



    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView descTextView;
        private CheckBox checkBox;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.task_title);
            descTextView = itemView.findViewById(R.id.task_description);
            checkBox = itemView.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            String titre =tasks.get(position).getTitre();
                            RequetesBD.deleteTask(titre, Connexion.getPseudo());
                            tasks.remove(position);
                            notifyItemRemoved(position);
                        }
                    }
                }
            });
        }
    }
}
