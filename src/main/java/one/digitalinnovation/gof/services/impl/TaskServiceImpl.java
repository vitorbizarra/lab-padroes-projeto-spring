package one.digitalinnovation.gof.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.models.Task;
import one.digitalinnovation.gof.models.TaskRepository;
import one.digitalinnovation.gof.services.TaskService;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<Task> all() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task find(Long id) {
        Optional<Task> task = this.taskRepository.findById(id);
        return task.get();
    }

    @Override
    public void insert(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public void update(Long id, Task task) {
        Optional<Task> taskDb = this.taskRepository.findById(id);

        if (taskDb.isPresent()) {
            this.taskRepository.save(task);
        }
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }
}
