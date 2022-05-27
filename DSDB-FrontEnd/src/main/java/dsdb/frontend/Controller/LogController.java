package dsdb.frontend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LogController {

    @GetMapping("/log")
    public ModelAndView tester(HttpSession session, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("log");
        modelAndView.addObject("user", session.getAttribute("user"));
        modelAndView.addObject("test", "Hej");
        return modelAndView;
    }
}
