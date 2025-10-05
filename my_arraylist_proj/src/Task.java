/**
 *Classe que representa uma tarefa - IBM Course
 *
 * @author Kaique Cardeal
 * @version 1.0
 */


public class Task {
    public static int HIGH = 3;
    public static int MEDIUM = 2;
    public static int LOW = 1;

    public static String COMPLETED = "Completo";
    public static String IN_PROGRESS = "Em processo";
    public static String NEW = "Novo";

    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return taskName.concat(" ").concat((priority+"").concat(" ").concat(status));
    }
}
