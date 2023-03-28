package com.example.connectbd.todo;


public class Task  {
    private String titre;
    private String description;

    public Task(String a , String b){
        titre=a;
        description=b;
    }

    public String getTitre(){
        return titre;
    }

    public String getDesc() {
        return description;
    }

}
