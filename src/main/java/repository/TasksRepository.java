package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Task;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TasksRepository {

    public static ArrayList<Task> readFromJsonFile(){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("tasks.json");

        if(!file.exists()){
            return new ArrayList<Task>();
        }

        try{
            return mapper.readValue(file, new TypeReference<ArrayList<Task>>() {});
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
            return new ArrayList<>();
        }
    }

    public static void saveTasksToJson(ArrayList<Task> tasks){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("tasks.json"), tasks);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
            throw new RuntimeException(e);
        }
    }
}
