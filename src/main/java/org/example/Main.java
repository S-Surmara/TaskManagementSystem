package org.example;

import org.example.ENUM.Priority;
import org.example.Entity.Task;
import org.example.Observer.User;
import org.example.Persistance.InMemory;
import org.example.Persistance.TaskPersistance;
import org.example.Persistance.UserPersistance;
import org.example.Persistance.inMemoryUser;
import org.example.State.PendingState;
import org.example.Stratergy.SortByDueTime;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Setup persistence
        TaskPersistance taskPersistance = new InMemory();
        UserPersistance userPersistance = new inMemoryUser();

        // Setup manager & controller
        TaskManager taskManager = new TaskManager(taskPersistance);
        SortByDueTime sortStrategy = new SortByDueTime();

        TaskController controller =
                new TaskController(taskPersistance, userPersistance, taskManager, sortStrategy);

        // Create user
        User user = new User("Kabir");
        userPersistance.saveUser(user);

        // Create Task
        taskManager.createTask(
                "Fix Login Bug",
                "Resolve null pointer issue",
                LocalDate.now(),
                Priority.HIGH,
                user
        );

        // Get task
        List<Task> tasks = taskPersistance.getAllTask();
        Task task = tasks.get(0);

        System.out.println("Task Created: " + task.getTitle());

        // Assign task
        controller.assignTask(task.getId(), "U1");

        // Set reminder
        controller.setReminder(task.getId(), LocalDate.now().plusDays(2));

        // Change state
        task.setTaskState(new PendingState());

        // Sort tasks
        List<Task> sortedTasks = controller.getSortedTaskList();
        System.out.println("Sorted Tasks Count: " + sortedTasks.size());
    }
}