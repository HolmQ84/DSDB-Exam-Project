package dsdb.frontend.Service;

import dsdb.frontend.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("DSDB-Users")
public interface UserClient {

    @GetMapping("/login/authenticate")
    public User authenticate(User user);

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id);

    @GetMapping("/users/")
    public List<User> getAllBooks();

    @PostMapping("/users/")
    public User createUser(@ModelAttribute User user);

    @PutMapping("/users/{id}")
    public User updateUser(@ModelAttribute User user, @PathVariable int id);

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id);
}
