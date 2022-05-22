package dsdb.users.Controller;

import dsdb.users.Model.User;
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

    @PostMapping("/authenticate")
    public User userLogin(@RequestBody User loginUser) {
        return loginService.validateLogin(loginUser);
    }
}
