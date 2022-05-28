package dsdb.logger.Controller;

import dsdb.logger.Model.LoggerInfo;
import dsdb.logger.Model.SongInfo;
import dsdb.logger.Repository.LoggerRepository;
import dsdb.logger.Repository.SongRepository;
import dsdb.logger.Service.KafkaService;
import dsdb.logger.Service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/logger")
@RestController
public class SongInfoController {

    @Autowired
    KafkaService kafkaService;

    @Autowired
    SongRepository songRepository;

    @Autowired
    LoggingService loggingService;

    @RequestMapping("/songs")
    public List<SongInfo> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/log")
    public List<LoggerInfo> getLoggerInfo(){
        return loggingService.getTimeLog();
    }
}
