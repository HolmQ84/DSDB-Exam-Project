package dsdb.frontend.Controller;

import dsdb.frontend.Model.LogInfoDTO;
import dsdb.frontend.Model.Session;
import dsdb.frontend.Model.User;
import dsdb.frontend.Service.LogInfoService;
import dsdb.frontend.Service.LoggerClient;
import dsdb.frontend.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LogController {

    @Autowired
    LoggerClient loggerClient;
    @Autowired
    LogInfoService logInfoService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/log")
    public ModelAndView getLogging(HttpSession session, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("log");
        sessionService.updateSession(session, response, "/log", null);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        List<Session> sessionList = loggerClient.getAllSessions();
        LogInfoDTO logInfoDTO = logInfoService.getLogInformation(sessionList);
        System.out.println(logInfoDTO);
        modelAndView.addObject("logInfo", logInfoDTO);
        modelAndView.addObject("sessions", sessionList);
        return modelAndView;
    }
}
