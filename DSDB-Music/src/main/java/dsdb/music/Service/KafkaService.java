package dsdb.music.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import dsdb.music.Model.Song;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@EnableMongoRepositories(basePackages = "dsdb.music.Repository")
@Service
public class KafkaService {

    @Autowired
    KafkaTemplate<String, String> template;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public void sendToMusicTopic(JSONObject object, String message) {
        String topic = "songs";
        object.put("loggerMessage", message);
        template.send(topic, object.toString());
        logger.info("Sent Info to Kafka - " + object);
        template.flush();
    }

    public JSONObject songToObject(Song song) {
        JSONObject object = new JSONObject();
        object.put("song_id", song.getSongId());
        object.put("title", song.getTitle());
        object.put("rank", song.getRank());
        object.put("date", song.getDate());
        object.put("artist", song.getArtist());
        object.put("spotify_url", song.getSpotifyUrl());
        object.put("region", song.getRegion());
        object.put("streams", song.getStreams());
        return object;
    }

    public Song convertSongToModel(JSONObject song) {
        Gson gson = new Gson();
        Type type = new TypeToken<Song>(){}.getType();
        return gson.fromJson(String.valueOf(song), type);
    }
}
