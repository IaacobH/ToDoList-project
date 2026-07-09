import model.Task;
import ui.App;

import java.util.ArrayList;
import java.util.Scanner;

import static repository.TasksRepository.readFromJsonFile;
import static repository.TasksRepository.saveTasksToJson;

public class Main {

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Task> tasks = readFromJsonFile();

        ui.App.run(tasks);

        saveTasksToJson(tasks);



    }
}
