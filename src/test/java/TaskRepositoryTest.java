import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

class TaskRepositoryTest {
    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }

    // ✅ Prueba para agregar tareas
    @Test
    void testAddTask() {
        repository.addTask("New Task");
        assertEquals(1, repository.getAllTasks().size());
    }

    // ✅ Prueba para encontrar una tarea por ID
    @Test
    void testFindTaskById() {
        repository.addTask("Task 1");
        Optional<Task> task = repository.findTaskById(1);
        assertTrue(task.isPresent());
        assertEquals("Task 1", task.get().getDescription());
    }

    // ❗ Prueba para encontrar una tarea que no existe
    @Test
    void testFindNonExistentTaskById() {
        Optional<Task> task = repository.findTaskById(999);
        assertFalse(task.isPresent());
    }

    // ✅ Prueba para eliminar una tarea existente
    @Test
    void testRemoveTask() {
        repository.addTask("Task to Remove");
        repository.removeTask(1);
        assertEquals(0, repository.getAllTasks().size());
    }

    // ❗ Prueba para eliminar una tarea que no existe
    @Test
    void testRemoveNonExistentTask() {
        repository.addTask("Task 1");
        repository.removeTask(99); // ID inexistente
        assertEquals(1, repository.getAllTasks().size());
    }
}
