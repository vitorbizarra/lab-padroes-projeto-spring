package one.digitalinnovation.gof.controllers;

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
import one.digitalinnovation.gof.models.User;
import one.digitalinnovation.gof.services.UserService;
import one.digitalinnovation.gof.services.impl.UserServiceImpl;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();

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
}
