package dsdb.users.Service;

import dsdb.users.Model.User;
import dsdb.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        User savedUser = userRepository.save(user);
        if (savedUser.getUsername() != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedUser.getUserId()).toUri();
            return savedUser;
        }
        return new User();
    }

    @Override
    public Optional<User> updateUser(User user, int id) {
        Optional<User> attendanceOptional = userRepository.findById(id);
        if (attendanceOptional.isEmpty())
            return Optional.empty();
        user.setUserId(id);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User successfully deleted.";
    }

    @Override
    public User createTestUser(User user) {
        return userRepository.save(user);
    }
}
