package one.digitalinnovation.gof.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import one.digitalinnovation.gof.models.Task;
import one.digitalinnovation.gof.models.User;
import one.digitalinnovation.gof.services.TaskService;
import one.digitalinnovation.gof.services.UserService;
import one.digitalinnovation.gof.services.impl.TaskServiceImpl;
import one.digitalinnovation.gof.services.impl.UserServiceImpl;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @Autowired
    private TaskService taskService = new TaskServiceImpl();

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return ResponseEntity.ok(this.userService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.find(id));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        this.userService.insert(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        this.userService.update(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Task routes
     */
    @GetMapping("/{id}/tasks")
    public ResponseEntity<Iterable<Task>> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.find(id).getTasks());
    }

    @GetMapping("/{id}/tasks/{taskId}")
    public ResponseEntity<Task> find(@PathVariable Long id, @PathVariable Long taskId) throws Exception {
        List<Task> tasks = this.userService.find(id).getTasks();

        Task task = tasks.stream().filter(item -> item.getId() == taskId).findFirst().orElse(null);

        if (task == null) {
            throw new Exception("task does not exists");
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<Task> insert(@PathVariable Long id, @RequestBody Task task) {

        this.taskService.insert(task);

        return ResponseEntity.ok(task);
    }
}
