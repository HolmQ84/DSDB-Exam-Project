package dsdb.logger.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsdb.logger.Model.AudioFeaturesInfo;
import dsdb.logger.Model.SessionInfo;
import dsdb.logger.Model.SongInfo;
import dsdb.logger.Model.UserInfo;
import dsdb.logger.Repository.FeatureRepository;
import dsdb.logger.Repository.SessionRepository;
import dsdb.logger.Repository.SongRepository;
import dsdb.logger.Repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    SessionRepository sessionRepository;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = "songs", groupId = "DSDB-Logger")
    public void songLoggerListener(String message) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").create();
            SongInfo songInfo = gson.fromJson(message, SongInfo.class);
            logger.info("Song added to logfile - message: " + songInfo.getLoggerMessage());
            songRepository.save(songInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "users", groupId = "DSDB-Logger")
    public void userLoggerListener(String message) {
        try {
            UserInfo userInfo = new Gson().fromJson(message, UserInfo.class);
            logger.info("User added to logfile - message: " + userInfo.getLoggerMessage());
            userRepository.save(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "features", groupId = "DSDB-Logger")
    public void featureLoggerListener(String message) {
        try {
            AudioFeaturesInfo features = new Gson().fromJson(message, AudioFeaturesInfo.class);
            logger.info("Features added to logfile - message: " + features.getLoggerMessage());
            featureRepository.save(features);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "stats", groupId = "DSDB-Logger")
    public void statsLoggerListener(String message) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").create();
            SessionInfo sessionInfo = gson.fromJson(message, SessionInfo.class);
            logger.info("Stats added to logfile");
            sessionRepository.save(sessionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
