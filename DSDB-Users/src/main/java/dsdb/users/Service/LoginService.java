package dsdb.users.Service;

import dsdb.users.Model.User;
import dsdb.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User validateLogin(User loginUser) {
        try {
            List<User> allUsers = userRepository.findAll();
            for (User current : allUsers) {
                if (current.getUsername().equals(loginUser.getUsername())) {
                    if (BCrypt.checkpw(loginUser.getPassword(), current.getPassword())) {
                        return current;
                    }
                    return new User();
                }
            }
            return new User();
        } catch (Exception exception) {
            System.out.println(exception);
            return new User();
        }
    }
}
