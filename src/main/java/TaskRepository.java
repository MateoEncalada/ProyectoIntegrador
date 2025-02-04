import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<Task>();
    private int nextId = 1;

    public void addTask(String description) {
        tasks.add(new Task(nextId++, description));
    }

    public List<Task> getAllTasks() {
        return new ArrayList<Task>(tasks);
    }

    public Optional<Task> findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    public void removeTask(int id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break; // Salir del bucle después de encontrar la tarea
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
        }
    }

}