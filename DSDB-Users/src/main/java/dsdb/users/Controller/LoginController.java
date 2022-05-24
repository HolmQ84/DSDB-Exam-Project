package dsdb.users.Controller;

import dsdb.users.Model.User;
import dsdb.users.Service.KafkaService;
import dsdb.users.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    KafkaService kafkaService;

    @PostMapping("/authenticate")
    public User userLogin(@RequestBody User loginUser) {
        User user = loginService.validateLogin(loginUser);
        if (user.getUsername() != null) {
            kafkaService.sendToUserTopic(kafkaService.userToObject(user), "User Login");
        }
        return user;
    }
}
