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
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}