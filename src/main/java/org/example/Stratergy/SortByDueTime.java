package org.example.Stratergy;

import org.example.Entity.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByDueTime implements SortStratergy{
    @Override
    public List<Task> getSortTask(List<Task> tasks){
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
        return tasks;
    }
}
