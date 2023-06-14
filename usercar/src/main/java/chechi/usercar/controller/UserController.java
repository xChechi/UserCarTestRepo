package chechi.usercar.controller;

import chechi.usercar.dto.UserRequest;
import chechi.usercar.entity.User;
import chechi.usercar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers () {

        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById (@PathVariable int id) {

        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable int id) {

        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser (@PathVariable int id, @RequestBody UserRequest request) {

        User existingUser = userService.findUserById(id);
        existingUser.setFirstName(request.getFirstName());
        return userService.updateUser(existingUser);
    }

    @PostMapping
    public void createUser (@Valid @RequestBody UserRequest request) {

        userService.createUser(request);
    }

}
