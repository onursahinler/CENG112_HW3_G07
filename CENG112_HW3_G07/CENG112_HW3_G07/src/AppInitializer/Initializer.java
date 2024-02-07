package AppInitializer;
import java.util.ArrayList;

import Comparators.BurstTimeComparator;
import Comparators.PriorityComparator;
import FileIO_package.FileIO;
import Implementations.LinkedList;
import Implementations.PriorityQueue;
import Implementations.SortedList;
import TaskPackage.Task;
import java.util.Collections;


public class Initializer {
    public void AppInitializer() {
        // Step 1: Read tasks from "tasks.txt" file
        ArrayList<Task> tasks = FileIO.readTasks("tasks.txt");
        LinkedList<Task> arrivalTimeList = new LinkedList<>();

        for (Task task : tasks) {
            // Add the task to the arrival time list
            arrivalTimeList.add(task);
        }

        // Step 2: Print the listed tasks with their name, burst time and arrival time information
        for (int i = 1; i <= arrivalTimeList.getLength(); i++) {
            Task task = arrivalTimeList.getEntry(i);
            System.out.println("Task Type: " + task.getTaskType() + ", Burst Time: " + task.getBurstTime() + ", Arrival Time: " + task.getArrivalDateTime());
        }

        // Step 3: Create two separate lists for sorting tasks by priority and burst time
        SortedList<Task> priorityList = new SortedList<>(new PriorityComparator());
        SortedList<Task> burstTimeList = new SortedList<>(new BurstTimeComparator());
        
        for (int i = 1; i <= arrivalTimeList.getLength(); i++) {
            Task task = arrivalTimeList.getEntry(i);

            // Add the task to the priority list
            priorityList.add(task);

            // Add the task to the burst time list
            burstTimeList.add(task);
        }
        Collections.sort(tasks, new PriorityComparator());
        Collections.reverse(tasks);  //getting the highest priority tasks to top to enqueue in order
        
     // Step 4: Create two separate queues for executing tasks based on priority and burst time
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Task> burstTimeQueue = new PriorityQueue<>();
        
        System.out.println(" ");
        System.out.println("Pile of waiting burst time according to the execution time:");
        for (int i = 1; i <= priorityList.getSize(); i++) {
            Task task = priorityList.getEntry(i);
            System.out.println("Task Type: " + task.getTaskType() + ", Burst Time: " 
            + task.getBurstTime() + ", Arrival Time: " + task.getArrivalDateTime());
        }
        
        for (int i =0 ; i<=tasks.size()-1; i++) {
        	Task task = tasks.get(i);
        	priorityQueue.enqueue(task);        //when enqueued they scramble again so the order is broken 
        										//could not fix but this is the way we know that
        }

        
        for (int i = 1; i <= burstTimeList.getSize(); i++) {
            Task task = burstTimeList.getEntry(i);		//same would happen in here too

            // Add the task to the burst time queue
            burstTimeQueue.enqueue(task);
        }

     // Step 5: Simulate task execution based on priority

        int executionCount = 0;
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.dequeue();
            System.out.println("Executing task based on priority: " + task.getTaskType() + (" ") + task.getPriority());

            executionCount++;
            if (executionCount % 5 == 0) {
            	System.out.println(" ");
            	System.out.println("Remaining tasks in priority queue:");
                Task[] remainingTasks = priorityQueue.toArray();
                for (Task remainingTask : remainingTasks) {
                    System.out.println("Task Type: " + remainingTask.getTaskType() + ", Burst Time: " 
                + remainingTask.getBurstTime() + ", Arrival Time: " + remainingTask.getArrivalDateTime());
                }
            }
        }
        System.out.println(" ");
        System.out.println("------------------------");
        // Step 6: Simulate task execution based on burst time
        System.out.println(" ");
        executionCount = 0;
        while (!burstTimeQueue.isEmpty()) {
            Task task = burstTimeQueue.dequeue();
            System.out.println("Executing task based on burst time: " + task.getTaskType() + (" ") + task.getBurstTime());

            executionCount++;
            if (executionCount % 5 == 0) {
                System.out.println(" ");
            	System.out.println("Remaining tasks in burst time queue:");
                Task[] remainingTasks = burstTimeQueue.toArray();
                for (Task remainingTask : remainingTasks) {
                    System.out.println("Task Type: " + remainingTask.getTaskType() + ", Burst Time: " 
                + remainingTask.getBurstTime() + ", Arrival Time: " + remainingTask.getArrivalDateTime());
                }
            }
        }
    }   
}

