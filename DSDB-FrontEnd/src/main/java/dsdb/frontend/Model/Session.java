package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Session implements Serializable {
    public int sessionId;
    public int userId;
    public List<String> pagesVisited = new ArrayList<>();
    public Date startTime;
    public Date endTime;

    public Session(int sessionId, int userId, List<String> pagesVisited, Date startTime, Date endTime) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.pagesVisited = pagesVisited;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Session(int userId) {
        this.userId = userId;
        this.startTime = new Date();
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getPagesVisited() {
        return pagesVisited;
    }

    public void setPagesVisited(List<String> pagesVisited) {
        this.pagesVisited = pagesVisited;
    }

    public void addPagesVisited(String page) {
        this.pagesVisited.add(page);
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
