package org.example.State;

import org.example.Entity.Task;

public class CompletedState implements TaskState{
    @Override
    public void startTask(Task task) {
        System.out.println("Task is already started & is in progress State");
    }
    @Override
    public void markDone(Task task) {
        System.out.println("Task is already done & is in completed State");
    }
    @Override
    public void resetProgress(Task task) {
        System.out.println("resetting the task to pending state");
        task.setTaskState(new PendingState());
    }
    @Override
    public void notifyDone(Task task){
        System.out.println("Notifying the assignee that task is done");
        task.notifyObservers();
    }
}
