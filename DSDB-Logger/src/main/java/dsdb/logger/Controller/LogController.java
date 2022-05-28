package dsdb.logger.Controller;

import dsdb.logger.Model.LoggerInfo;
import dsdb.logger.Service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/log")
@RestController
public class LogController {

    @Autowired
    LoggingService loggingService;

    @GetMapping("/log")
    public List<LoggerInfo> getLoggerInfo(){
        return loggingService.getTimeLog();
    }

    @GetMapping("/log2")
    public List<LoggerInfo> getAllLog(){
        return loggingService.getAll();
    }

}
