package dsdb.logger.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document("sessions")
public class Session implements Serializable {
    public int sessionId;
    public int userId;
    public List<String> pagesVisited = new ArrayList<>();
    public Date startTime;
    public Date endTime;

    public Session(int userId) {
        this.userId = userId;
        this.startTime = new Date();
    }
}
