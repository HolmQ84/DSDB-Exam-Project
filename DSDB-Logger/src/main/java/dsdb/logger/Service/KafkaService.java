package dsdb.logger.Service;

import com.google.gson.Gson;
import dsdb.logger.Model.Song;
import dsdb.logger.Repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableMongoRepositories(basePackages = "dsdb.logger.Repository")
@Service
public class KafkaService {

    @Autowired
    SongRepository songRepository;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = "songs", groupId = "DSDB-Logger")
    public void newGames(String message) {
        try {
            Song song = new Gson().fromJson(message, Song.class);
            logger.info("Song added to logfile - message: " + song.getLoggerMessage());
            songRepository.save(song);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
