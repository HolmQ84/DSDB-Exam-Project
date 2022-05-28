package dsdb.logger.Repository;

import dsdb.logger.Model.LoggerInfo;
import dsdb.logger.Model.SongInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository extends MongoRepository<SongInfo, Integer> {

    @Query("{name: 'Troels'}")
    List<LoggerInfo> getTimeLog();


}