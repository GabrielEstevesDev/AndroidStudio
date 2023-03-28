package com.example.connectbd.todo;

import java.util.ArrayList;

public class ListTask {
    protected static ArrayList<Task> tasks=new ArrayList<>();

    public static  void setTasks(ArrayList<Task> a){
        tasks=a;
    }
    protected static ArrayList<Task> GetList(){
        return tasks;
    }

}
