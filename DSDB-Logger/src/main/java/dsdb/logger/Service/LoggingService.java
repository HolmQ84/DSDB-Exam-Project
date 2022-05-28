package dsdb.logger.Service;

import dsdb.logger.Model.LoggerInfo;
import dsdb.logger.Repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableMongoRepositories(basePackages = "dsdb.logger.Repository")
@Service
public class LoggingService {

    @Autowired
    LoggerRepository loggerRepository;

    public List<LoggerInfo> getTimeLog() {
        System.out.println(loggerRepository.getTimeLog());
        return loggerRepository.getTimeLog();
    }

}
