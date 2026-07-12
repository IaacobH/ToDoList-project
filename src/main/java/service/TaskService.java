package service;

import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskService {
    public enum Result {
        OK,
        ERROR
    }

    public static boolean addTask(String title, String desc, LocalDate date, ArrayList<Task> tasks){
        Task task = new Task(title, desc, date);
        tasks.add(task);
        return true;
    }

    public static boolean markTaskAsCompleted(ArrayList<Task> tasks, String title){
        Task task = findTaskByTitle(tasks, title);
        if (task == null){
            return false;
        }
        task.setCompleted(true);
        return true;
    }

    public static Task findTaskByTitle(ArrayList<Task> tasks, String title){
        for (Task t : tasks){
            if (t.getTitle().trim().equalsIgnoreCase(title.trim())){
                return t;
            }
        }
        return null;
    }

    public static boolean deleteTaskByTitle(ArrayList<Task> tasks, String title){
        Task task = findTaskByTitle(tasks, title);
        if (task == null) {
            return false;
        }
        tasks.remove(task);
        return true;

    }


}
