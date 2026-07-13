import model.Item;

import java.util.ArrayList;

import static repository.ItemsRepository.readFromJsonFile;
import static repository.ItemsRepository.saveTasksToJson;

public class Main {

    static void main(String[] args) {

        ArrayList<Item> items = readFromJsonFile();

        ui.App.run(items);

        saveTasksToJson(items);

    }
}
