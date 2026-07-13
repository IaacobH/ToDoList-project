package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Item;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ItemsRepository {

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    public static ArrayList<Item> readFromJsonFile() {
        ObjectMapper mapper = createMapper();
        File file = new File("items.json");

        if (!file.exists()) {
            return new ArrayList<Item>();
        }

        try {
            return mapper.readValue(file, new TypeReference<ArrayList<Item>>() {
            });
        } catch (IOException e) {
            System.out.println("Error loading items.");
            return new ArrayList<>();
        }
    }

    public static void saveTasksToJson(ArrayList<Item> items) {
        ObjectMapper mapper = createMapper();
        try {
            mapper.writerFor(new TypeReference<ArrayList<Item>>() {})
                    .withDefaultPrettyPrinter()
                    .writeValue(new File("items.json"), items);
            System.out.println("Items saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving items.");
            throw new RuntimeException(e);
        }
    }
}
