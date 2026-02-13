package org.example.State;

import org.example.Entity.Task;

public interface TaskState {
    public void startTask(Task task);
    public void markDone(Task task);
    public void resetProgress(Task task);
    public void notifyDone(Task task);
}
