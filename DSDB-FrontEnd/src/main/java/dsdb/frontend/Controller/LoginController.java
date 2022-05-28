package dsdb.frontend.Controller;

import dsdb.frontend.Model.Session;
import dsdb.frontend.Model.User;
import dsdb.frontend.Service.SessionService;
import dsdb.frontend.Service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    UserClient userClient;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public ModelAndView loginPage(HttpSession session, HttpServletResponse response, @ModelAttribute User model) {
        sessionService.loginCheck(session, response);
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", model);

        session.setAttribute("user", new User());
        modelAndView.addObject("user", session.getAttribute("user"));
        return modelAndView;
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, @ModelAttribute User loginUser) {
        User user = userClient.authenticate(loginUser);
        if (user.getUsername() != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("session", new Session(user.getUserId()));
            return new RedirectView("/");
        }
        return new RedirectView("/login");
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", session.getAttribute("user"));
        if (session.getAttribute("session") != null) {
            sessionService.updateSession(session, response, "Index Page", null);
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpSession session) {
        sessionService.saveSessionData(session);
        session = request.getSession(false);
        session.invalidate();
        return new RedirectView("/login");
    }
}
