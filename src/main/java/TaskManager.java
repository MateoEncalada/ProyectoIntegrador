import java.util.List;

public class TaskManager {
    private final TaskRepository repository = new TaskRepository();

    public void addTask(String description) {
        repository.addTask(description);
        System.out.println("Task added.");
    }

    public void listTasks() {
        final List<Task> tasks = repository.getAllTasks(); // ✅ Solución: 'final' agregado
        for (Task task : tasks) {
            System.out.println("Task " + task.getId() + ": " + task.getDescription());
        }
    }

    public void removeTask(int id) {
        if (repository.findTaskById(id).isPresent()) {
            repository.removeTask(id);
            System.out.println("Task removed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // ✅ Método agregado para las pruebas unitarias
    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }
}
