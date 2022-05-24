package dsdb.users.Service;

import dsdb.users.Model.User;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    KafkaTemplate<String, String> template;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public void sendToUserTopic(JSONObject object, String message) {
        String topic = "users";
        object.put("loggerMessage", message);
        template.send(topic, object.toString());
        logger.info("Sent Info to Kafka - " + object);
        template.flush();
    }

    public JSONObject userToObject(User user) {
        JSONObject object = new JSONObject();
        object.put("userId", user.getUserId());
        object.put("email", user.getEmail());
        object.put("username", user.getUsername());
        object.put("userLevel", user.getUserLevel());
        return object;
    }
}
