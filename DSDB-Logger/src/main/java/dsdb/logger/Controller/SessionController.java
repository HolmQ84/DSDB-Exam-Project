package dsdb.logger.Controller;

import dsdb.logger.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stats")
@RestController
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/sessions")
    public String returnSessions() {
        return "";
    }
}
