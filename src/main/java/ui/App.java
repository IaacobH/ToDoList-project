package ui;

import model.Task;
import service.Service;

import java.util.ArrayList;
import java.util.Scanner;

import static repository.TasksRepository.saveTasksToJson;

public class App {

    public App() {
    }

    public static void showMenu(){
        System.out.println();
        System.out.println("===== TASK MANAGER =====");
        System.out.println("1. Add a new task");
        System.out.println("2. Mark a task as completed");
        System.out.println("3. Show pending tasks");
        System.out.println("4. Save tasks to Json");
        System.out.println("5. Show all tasks");
        System.out.println("6. Search task by title");
        System.out.println("7. Delete task by title");
        System.out.println("8. Exit");
    }

    public static void addTask (Scanner input, ArrayList<Task> tasks){
        String title = ui.InputUtils.getString(input, "title: ");
        if (title.trim().isEmpty()){
            System.out.println("Empty title is not allowed.");
            return;
        }
        String desc = ui.InputUtils.getString(input, "description: ");
        Task task = new Task(title, desc);
        tasks.add(task);
    }

    public static void markTaskAsCompleted(Scanner input, ArrayList<model.Task> tasks){
        String title = ui.InputUtils.getString(input,"name of the task: ");
        Task task = findTaskByTitle(tasks, title);
        if (task == null){
            System.out.println("task not found");
            return;
        }
        task.setCompleted();
        System.out.println("task marked as completed");
    }

    public static void showPendingTasks(ArrayList<Task> tasks){
        for (Task t : tasks){
            if (!t.isCompleted()){
                System.out.println(t);
            }
        }
    }

    public static void showAllTasks(ArrayList<Task> tasks){
        System.out.println("all the tasks: ");
        for(Task t : tasks){
            System.out.println(t);
        }
    }

    public static Task findTaskByTitle(ArrayList<Task> tasks, String title){
        for (Task t : tasks){
            if (t.getTitle().equalsIgnoreCase(title)){
                return t;
            }
        }
        return null;
    }

    public static void searchTaskByTitle(Scanner input, ArrayList<Task> tasks){
        String title = InputUtils.getString(input, "enter the title: ");
        Task task = findTaskByTitle(tasks, title);
        if(task == null){
            System.out.println("task not found.");
        }else{
            System.out.println("task found: ");
            System.out.println(task);
        }
    }

    public static boolean deleteTaskByTitle(ArrayList<Task> tasks, String title){
        Task task = findTaskByTitle(tasks, title);
        if(task == null){
            return false;
        }else{
            tasks.remove(task);
            return true;
        }
    }

    public static void handleDeleteTask(Scanner input, ArrayList<Task> tasks){
        String title = InputUtils.getString(input, "task name: ");
        boolean deleted = deleteTaskByTitle(tasks, title);
        if (deleted) {
            System.out.println("Task deleted successfully.");
            return;
        }
        System.out.println("task not found.");

    }

    public static void  run(ArrayList<Task> tasks){
        Scanner input = new Scanner(System.in);
        int choice;
        boolean runing = true;

        while(runing) {
            showMenu();
            choice = ui.InputUtils.getInt(input, "Choose an option: ");

            switch (choice) {
                case 1 -> addTask(input, tasks);
                case 2 -> markTaskAsCompleted(input, tasks);
                case 3 -> showPendingTasks(tasks);
                case 4 -> saveTasksToJson(tasks);
                case 5 -> showAllTasks(tasks);
                case 6 -> searchTaskByTitle(input, tasks);
                case 7 -> handleDeleteTask(input, tasks);
                case 8 -> {
                    runing = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }



    }
}
