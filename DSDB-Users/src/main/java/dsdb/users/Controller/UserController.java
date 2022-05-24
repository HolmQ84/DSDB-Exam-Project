package dsdb.users.Controller;

import dsdb.users.Model.User;
import dsdb.users.Service.FakerUsers;
import dsdb.users.Service.KafkaService;
import dsdb.users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    KafkaService kafkaService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable int userId) throws Exception {
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (newUser.getUsername() != null) {
            kafkaService.sendToUserTopic(kafkaService.userToObject(newUser), "New User");
        }
        return newUser;
    }

    @PutMapping("/{id}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/createRandomUser")
    public User createRandomUser() {
        FakerUsers fakerUser = new FakerUsers();
        User user = fakerUser.createFakeUser();
        try {
            userService.createTestUser(user);
            return user;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new User();
        }
    }
}
