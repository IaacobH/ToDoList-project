package ui;

import model.Task;

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
        System.out.println("4. Save tasks to file");
        System.out.println("5. Show all tasks");
        System.out.println("6. Exit");
    }

    public static void addTask (Scanner input, ArrayList<Task> tasks){
        String title = ui.InputUtils.getString(input, "title: ");
        String desc = ui.InputUtils.getString(input, "description: ");
        Task task = new Task(title, desc);
        tasks.add(task);
    }

    public static void markTaskAsCompleted(Scanner input, ArrayList<model.Task> tasks){
        Task task = getTaskByName(input, tasks);
        if (task == null){
            System.out.println("task not found");
            return;
        }
        task.setCompleted();
        System.out.println("task marked as completed");
    }

    public static Task getTaskByName(Scanner input, ArrayList<model.Task> tasks){
        String name = ui.InputUtils.getString(input,"name of the task: ");
        for(Task t : tasks){
            if (name.equals(t.getTitle())){
                return t;
            }
        }
        return null;
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

    public static void  run(ArrayList<Task> tasks){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = ui.InputUtils.getInt(input, "Choose an option: ");

            switch (choice) {
                case 1:
                    addTask(input, tasks);
                    break;
                case 2:
                markTaskAsCompleted(input, tasks);
                    break;
                case 3:
                    showPendingTasks(tasks);
                    break;
                case 4:
                    saveTasksToJson(tasks);
                    break;
                case 5:
                    showAllTasks(tasks);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(choice != 6);
    }
}
