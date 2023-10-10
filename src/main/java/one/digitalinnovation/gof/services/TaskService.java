package one.digitalinnovation.gof.services;

import one.digitalinnovation.gof.models.Task;

public interface TaskService {
    Iterable<Task> all();

    Task find(Long id);

    void insert(Task task);

    void update(Long id, Task task);

    void delete(Long id);
}
