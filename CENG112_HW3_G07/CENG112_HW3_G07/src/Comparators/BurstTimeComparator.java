package Comparators;

import java.util.Comparator;
import TaskPackage.Task;

public class BurstTimeComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        // Compare tasks based on their burst time
        return Integer.compare(t1.getBurstTime(), t2.getBurstTime());
    }
}

