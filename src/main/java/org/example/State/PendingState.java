package org.example.State;

import org.example.Entity.Task;

public class PendingState implements TaskState{
    @Override
    public void startTask(Task task) {
        System.out.println("Started Task, will move state to progress");
        task.setTaskState(new ProgressState());
    }
    @Override
    public void markDone(Task task) {
        System.out.println("cant mark the task as done without moving it in progress state");
    }
    @Override
    public void resetProgress(Task task) {
        System.out.println("task is already in pending state");
    }
    @Override
    public void notifyDone(Task task){
        System.out.println("cant notify now as task is not yet completed & is in pending state");
    }
}
