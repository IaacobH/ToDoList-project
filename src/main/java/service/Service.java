package service;

import model.Task;

import java.util.ArrayList;

public class Service {
    public enum Result {
        OK,
        ERROR
    }

    ArrayList<Task> tasks = new ArrayList<>();

    public Service(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Result addTask(String title, String desc){
        if(title.trim().isEmpty()){
            return Result.ERROR;
        }
        Task task = new Task(title, desc);
        tasks.add(task);
        return Result.OK;
    }
}
