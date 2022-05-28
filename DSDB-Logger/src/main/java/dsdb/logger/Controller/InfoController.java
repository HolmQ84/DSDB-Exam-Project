package dsdb.logger.Controller;

import dsdb.logger.Model.FeaturesInfo;
import dsdb.logger.Model.SongInfo;
import dsdb.logger.Model.UserInfo;
import dsdb.logger.Repository.FeatureRepository;
import dsdb.logger.Repository.SongRepository;
import dsdb.logger.Repository.UserRepository;
import dsdb.logger.Service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/logger")
@RestController
public class InfoController {

    @Autowired
    KafkaService kafkaService;
    @Autowired
    SongRepository songRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FeatureRepository featureRepository;

    @RequestMapping("/songs")
    public List<SongInfo> getAllSongs() {
        return songRepository.findAll();
    }

    @RequestMapping("/users")
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/features")
    public List<FeaturesInfo> getAllFeatures() {
        return featureRepository.findAll();
    }
}
