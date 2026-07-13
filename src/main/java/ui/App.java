package ui;

import model.Item;
import model.Task;
import service.ItemService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public App() {
    }

    public static void  run(ArrayList<Item> items){
        Scanner input = new Scanner(System.in);
        int choice;
        boolean running = true;

        while(running) {
            showMenu();
            choice = ui.InputUtils.getInt(input, "Choose an option: ");

            switch (choice) {
                case 1 -> handleAddTask(input, items);
                case 2 -> handleAddEvent(input, items);
                case 3 -> handleAddBirthday(input, items);
                case 4 -> handleMarkTaskAsCompleted(input, items);
                case 5 -> showPendingTasks(items);
                case 6 -> showAllItems(items);
                case 7 -> searchTaskByTitle(input, items);
                case 8 -> handleDeleteTask(input, items);
                case 9 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

    }

    public static void showMenu(){
        System.out.println();
        System.out.println("===== TASK MANAGER =====");
        System.out.println("1. Add a new task");
        System.out.println("2. Add a new event");
        System.out.println("3. Add a new birthday");
        System.out.println("4. Mark a task as completed");
        System.out.println("5. Show pending tasks");
        System.out.println("6. Show all items");
        System.out.println("7. Search task by title");
        System.out.println("8. Delete task by title");
        System.out.println("9. Exit");
    }

    public static void handleAddTask(Scanner input, ArrayList<Item> items){
        String title = InputUtils.getString(input, "title: ");
        if (title.trim().isEmpty()){
            System.out.println("Empty title is not allowed.");
            return;
        }
        String desc = InputUtils.getString(input, "description: ");

        LocalDate date = InputUtils.getDate(input, "Enter date (dd/MM/yyyy): ");

        boolean added = ItemService.addTask(title, desc, date, items);
        if (added){
            System.out.println("Task added successfully");
            return;
        }
        System.out.println("Error adding the task");
    }

    public static void handleAddEvent(Scanner input, ArrayList<Item> items){
        String title = InputUtils.getString(input, "title: ");
        if (title.trim().isEmpty()){
            System.out.println("Empty title is not allowed.");
            return;
        }
        String desc = InputUtils.getString(input, "description: ");

        LocalDate date = InputUtils.getDate(input, "Enter date (dd/MM/yyyy): ");

        boolean added = ItemService.addEvent(title, desc, date, items);
        if (added){
            System.out.println("Event added successfully");
            return;
        }
        System.out.println("Error adding the event");
    }

    public static void handleAddBirthday(Scanner input, ArrayList<Item> items){
        String person = InputUtils.getString(input, "name of the person: ");
        if (person.trim().isEmpty()){
            System.out.println("Empty name is not allowed.");
            return;
        }
        String desc = InputUtils.getString(input, "description: ");
        String phoneNumber = InputUtils.getString(input, "phoneNumber: ");
        LocalDate date = InputUtils.getDate(input, "Enter date (dd/MM/yyyy): ");

        boolean added = ItemService.addBirthday(desc, date, person, phoneNumber, items);
        if (added){
            System.out.println("birthday added successfully");
            return;
        }
        System.out.println("Error adding the birthday");
    }

    public static void handleMarkTaskAsCompleted(Scanner input, ArrayList<Item> items){
        String title = ui.InputUtils.getString(input,"Title: ");
        if (title.trim().isEmpty()) {
            System.out.println("Task name cannot be empty.");
            return;
        }
        boolean marked = ItemService.markTaskAsCompleted(items, title);
        if(marked){
            System.out.println("Task marked as completed.");
            return;
        }
        System.out.println("Task not found.");
    }


    public static void showPendingTasks(ArrayList<Item> items){
        System.out.println("Pending tasks: ");
        for (Item item : items){
            if (item instanceof Task task && !task.isCompleted()){
                System.out.println(task);
            }
        }
    }

    public static void showAllItems(ArrayList<Item> items){
        System.out.println("All the items: ");
        for(Item item : items){
            System.out.println(item);
        }
    }

    public static void searchTaskByTitle(Scanner input, ArrayList<Item> items){
        String title = InputUtils.getString(input, "enter the title: ");
        Task task = ItemService.findTaskByTitle(items, title);
        if(task == null){
            System.out.println("task not found.");
        }else{
            System.out.println("task found: ");
            System.out.println(task);
        }
    }

    public static void handleDeleteTask(Scanner input, ArrayList<Item> items){
        String title = InputUtils.getString(input, "task name: ");
        if (title.trim().isEmpty()) {
            System.out.println("Task name cannot be empty.");
            return;
        }
        boolean deleted = ItemService.deleteTaskByTitle(items, title);
        if (deleted) {
            System.out.println("Task deleted successfully.");
            return;
        }
        System.out.println("task not found.");

    }

}
