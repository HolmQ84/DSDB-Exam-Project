package dsdb.logger.Repository;

import dsdb.logger.Model.SongInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<SongInfo, Integer> {
}
