public class TaskManager {
    private final TaskRepository repository = new TaskRepository();

    public void addTask(String description) {
        repository.addTask(description);
        System.out.println("Task added.");
    }

    public void listTasks() {
        for (Task task : repository.getAllTasks()) {
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

}