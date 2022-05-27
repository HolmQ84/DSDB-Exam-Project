package dsdb.frontend.Service;

import dsdb.frontend.Model.Session;
import dsdb.frontend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class SessionService {

    @Autowired
    KafkaService kafkaService;

    public void loginCheck(HttpSession session, HttpServletResponse response) {
        User current = (User) session.getAttribute("user");
        try {
            if (current.getUsername() != null) {
                System.out.println("Login Check - User is logged in.");
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on loginCheck");
        }
    }

    public void sessionCheck(HttpSession session, HttpServletResponse response) {
        User current = (User) session.getAttribute("user");
        try {
            if (current.getUsername() == null) {
                System.out.println("Session Check - User is null");
                response.sendRedirect("/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on sessionCheck");
        }
    }

    public void updateSession(HttpSession session, HttpServletResponse response, String url, String searchQuery) {
        sessionCheck(session, response);
        Session currentSession = (Session) session.getAttribute("session");
        if (searchQuery != null) {
            currentSession.addPagesVisited(url + " (With search query: " + searchQuery + ")");
        } else {
            currentSession.addPagesVisited(url);
        }
        session.setAttribute("session", currentSession);
    }

    public void saveSessionData(HttpSession session) {
        Session currentSession = (Session) session.getAttribute("session");
        currentSession.setEndTime(new Date());
        kafkaService.sendToStatsTopic(kafkaService.sessionToObject(currentSession));
    }
}
