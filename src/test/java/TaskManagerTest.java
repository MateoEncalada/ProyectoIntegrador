import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    // ✅ Prueba para agregar una tarea
    @Test
    void testAddTask() {
        taskManager.addTask("Test Task");
        assertEquals(1, taskManager.getAllTasks().size());
        assertEquals("Test Task", taskManager.getAllTasks().get(0).getDescription());
    }

    // ✅ Prueba para eliminar una tarea existente
    @Test
    void testRemoveTask() {
        taskManager.addTask("Task to Remove");
        taskManager.removeTask(1);
        assertEquals(0, taskManager.getAllTasks().size());
    }

    // ❗ Prueba para eliminar una tarea que no existe
    @Test
    void testRemoveNonExistentTask() {
        taskManager.addTask("Existing Task");
        taskManager.removeTask(99); // ID inexistente
        assertEquals(1, taskManager.getAllTasks().size());
    }

    // ✅ Prueba para listar tareas
    @Test
    void testListTasks() {
        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        assertEquals(2, taskManager.getAllTasks().size());
    }

    // ✅ Prueba para obtener una tarea por ID
    @Test
    void testFindTaskById() {
        taskManager.addTask("Important Task");
        Optional<Task> task = taskManager.getAllTasks().stream()
                .filter(t -> t.getId() == 1)
                .findFirst();
        assertTrue(task.isPresent());
        assertEquals("Important Task", task.get().getDescription());
    }

    // ❗ Prueba para obtener una tarea con un ID inexistente
    @Test
    void testFindNonExistentTaskById() {
        Optional<Task> task = taskManager.getAllTasks().stream()
                .filter(t -> t.getId() == 99)
                .findFirst();
        assertFalse(task.isPresent());
    }
}
