package Comparators;

import java.util.Comparator;

import TaskPackage.Task;

public class PriorityComparator implements Comparator<Task> {
    
    public int compare(Task t1, Task t2) {
        // Compare tasks based on their priority
        // For example, you can compare the priority property of each task
        return Integer.compare(t1.getPriority(), t2.getPriority());
    }
}
