package dsdb.frontend.Controller;

import dsdb.frontend.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginPage(HttpSession session, HttpServletResponse response, @ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject(user);
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", new User());
        }
        modelAndView.addObject("user", session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }
}
