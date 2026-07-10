package ui;

import model.Task;
import service.TaskService;
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

    public static void handleAddTask(Scanner input, ArrayList<Task> tasks){
        String title = ui.InputUtils.getString(input, "title: ");
        if (title.trim().isEmpty()){
            System.out.println("Empty title is not allowed.");
            return;
        }
        String desc = ui.InputUtils.getString(input, "description: ");
        boolean added = TaskService.addTask(title, desc, tasks);
        if (added){
            System.out.println("Task added successfully");
            return;
        }
        System.out.println("Error adding the task");
    }

    public static void handleMarkTaskAsCompleted(Scanner input, ArrayList<Task> tasks){
        String title = ui.InputUtils.getString(input,"Title: ");
        if (title.trim().isEmpty()) {
            System.out.println("Task name cannot be empty.");
            return;
        }
        boolean marked = TaskService.markTaskAsCompleted(tasks, title);
        if(marked){
            System.out.println("Task marked as completed.");
            return;
        }
        System.out.println("Task not found.");
    }


    public static void showPendingTasks(ArrayList<Task> tasks){
        System.out.println("Pending tasks: ");
        for (Task t : tasks){
            if (!t.isCompleted()){
                System.out.println(t);
            }
        }
    }

    public static void showAllTasks(ArrayList<Task> tasks){
        System.out.println("All the tasks: ");
        for(Task t : tasks){
            System.out.println(t);
        }
    }

    public static void searchTaskByTitle(Scanner input, ArrayList<Task> tasks){
        String title = InputUtils.getString(input, "enter the title: ");
        Task task = TaskService.findTaskByTitle(tasks, title);
        if(task == null){
            System.out.println("task not found.");
        }else{
            System.out.println("task found: ");
            System.out.println(task);
        }
    }

    public static void handleDeleteTask(Scanner input, ArrayList<Task> tasks){
        String title = InputUtils.getString(input, "task name: ");
        if (title.trim().isEmpty()) {
            System.out.println("Task name cannot be empty.");
            return;
        }
        boolean deleted = TaskService.deleteTaskByTitle(tasks, title);
        if (deleted) {
            System.out.println("Task deleted successfully.");
            return;
        }
        System.out.println("task not found.");

    }

    public static void  run(ArrayList<Task> tasks){
        Scanner input = new Scanner(System.in);
        int choice;
        boolean running = true;

        while(running) {
            showMenu();
            choice = ui.InputUtils.getInt(input, "Choose an option: ");

            switch (choice) {
                case 1 -> handleAddTask(input, tasks);
                case 2 -> handleMarkTaskAsCompleted(input, tasks);
                case 3 -> showPendingTasks(tasks);
                case 4 -> saveTasksToJson(tasks);
                case 5 -> showAllTasks(tasks);
                case 6 -> searchTaskByTitle(input, tasks);
                case 7 -> handleDeleteTask(input, tasks);
                case 8 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
