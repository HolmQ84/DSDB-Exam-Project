package dsdb.logger.Controller;

import dsdb.logger.Model.SessionInfo;
import dsdb.logger.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/sessions")
@RestController
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/")
    public List<SessionInfo> returnSessions() {
        return sessionRepository.findAll();
    }
}
