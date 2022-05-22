package dsdb.users.Service;

import dsdb.users.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

//@Service
public interface UserService {
    List<User> getAllUsers();
    ResponseEntity<Object> getUserById(int id) throws Exception;
    ResponseEntity<User> createUser(User user);
    Optional<User> updateUser(User user, int id);
    String deleteUser(int id);
    User createTestUser(User user);
}
