package dsdb.frontend.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import dsdb.frontend.Model.Session;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class KafkaService {

    @Autowired
    KafkaTemplate<String, String> template;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public void sendToStatsTopic(JSONObject object) {
        String topic = "stats";
        template.send(topic, object.toString());
        logger.info("Sent Session stats to Kafka - " + object);
        template.flush();
    }

    public JSONObject sessionToObject(Session session) {
        JSONObject object = new JSONObject();
        object.put("sessionId", session.getSessionId());
        object.put("userId", session.getUserId());
        object.put("pagesVisited", session.getPagesVisited());
        object.put("startTime", session.getStartTime());
        object.put("endTime", session.getEndTime());
        return object;
    }

    public Session convertSongToModel(JSONObject session) {
        Gson gson = new Gson();
        Type type = new TypeToken<Session>(){}.getType();
        return gson.fromJson(String.valueOf(session), type);
    }
}
