package dsdb.frontend.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class SessionService {

    public void loginCheck(HttpSession session, HttpServletResponse response) {
        try {
            if (session.getAttribute("user") != null) {
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sessionCheck(HttpSession session, HttpServletResponse response) {
        try {
            if (session.getAttribute("user") == null) {
                response.sendRedirect("/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
