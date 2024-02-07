package FileIO_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import TaskPackage.Task;

public class FileIO {
    public static ArrayList<Task> readTasks(String fileName) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskProperties = line.split(",");
                String taskType = taskProperties[0];
                int burstTime = Integer.parseInt(taskProperties[1]);
                String arrivalDate = taskProperties[2];
                String arrivalTime = taskProperties[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDate + " " + arrivalTime, formatter);
                Task task = new Task(taskType, burstTime, arrivalDateTime);
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}