package TaskPackage;
import java.time.LocalDateTime;


public class Task implements Comparable<Task> {
    private String taskType;
    private int burstTime;
    private LocalDateTime arrivalDateTime;
    private int priority;
    public Task(String taskType, int burstTime, LocalDateTime arrivalDateTime) {
        this.taskType = taskType;
        this.burstTime = burstTime;
        this.arrivalDateTime = arrivalDateTime;
     // Set the priority of the task based on its task type
        switch (taskType) {
            case "security management":
                this.priority = 6;
                break;
            case "process management":
                this.priority = 5;
                break;
            case "memory management":
                this.priority = 4;
                break;
            case "user management":
                this.priority = 3;
                break;
            case "device management":
                this.priority = 2;
                break;
            case "file management":
                this.priority = 1;
                break;
            default:
                // Set a default priority for tasks with an unknown task type
                this.priority = 0;
                break;
        }
    }

    public String getTaskType() {
        return taskType;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    @Override
    public int compareTo(Task other) {
        return arrivalDateTime.compareTo(other.arrivalDateTime);
    }
    public int getPriority() {
        return priority;
    }

}


