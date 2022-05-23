package dsdb.logger.Controller;

import dsdb.logger.Model.Song;
import dsdb.logger.Repository.SongRepository;
import dsdb.logger.Service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/logger")
@RestController
public class SongController {

    @Autowired
    KafkaService kafkaService;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/songs")
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
