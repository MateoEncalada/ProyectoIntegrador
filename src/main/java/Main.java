public class Main {
    public static void main(String[] args) {
        final TaskManager taskManager = new TaskManager(); // Agregamos 'final'
        taskManager.addTask("Complete project");
        taskManager.listTasks();
        taskManager.removeTask(1);
    }
}
