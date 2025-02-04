import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void testAddTask() {
        taskManager.addTask("Test task");
        assertEquals(1, taskManager.getAllTasks().size());
    }

    @Test
    void testRemoveTask() {
        taskManager.addTask("Test task");
        taskManager.removeTask(1);
        assertEquals(0, taskManager.getAllTasks().size());
    }
}
