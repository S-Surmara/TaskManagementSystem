package org.example.State;

import org.example.Entity.Task;

public class ProgressState implements TaskState{
    @Override
    public void startTask(Task task) {
        System.out.println("Task is already started & is in progress State");
    }
    @Override
    public void markDone(Task task) {
        System.out.println("Marking task as done & moving state to done");
        task.setTaskState(new CompletedState());
    }
    @Override
    public void resetProgress(Task task) {
        System.out.println("resetting the task to pending state");
        task.setTaskState(new PendingState());
    }
    @Override
    public void notifyDone(Task task){
        System.out.println("cant notify now as task is not yet completed & is in progress state");
    }
}
