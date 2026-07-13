package service;

import model.Birthday;
import model.Event;
import model.Item;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class ItemService {
    public enum Result {
        OK,
        ERROR
    }

    public static boolean addTask(String title, String desc, LocalDate date, ArrayList<Item> items){
        Task task = new Task(title, desc, date);
        items.add(task);
        return true;
    }

    public static boolean addEvent(String title, String desc, LocalDate date, ArrayList<Item> items){
        var event = new Event(title, desc, date);
        items.add(event);
        return true;
    }

    public static boolean addBirthday(String description, LocalDate date, String birthdayPerson, String phoneNumber, ArrayList<Item> items){
        var birthday = new Birthday(description, date, birthdayPerson, phoneNumber);
        items.add(birthday);
        return true;
    }

    public static boolean markTaskAsCompleted(ArrayList<Item> items, String title){
        Task task = findTaskByTitle(items, title);
        if (task == null){
            return false;
        }
        task.setCompleted(true);
        return true;
    }

    public static Task findTaskByTitle(ArrayList<Item> items, String title){
        for (Item item : items){
            if (item instanceof Task task &&
                    task.getTitle().trim().equalsIgnoreCase(title.trim())){
                return task;
            }
        }
        return null;
    }

    public static boolean deleteTaskByTitle(ArrayList<Item> items, String title){
        Task task = findTaskByTitle(items, title);
        if (task == null) {
            return false;
        }
        items.remove(task);
        return true;

    }


}
