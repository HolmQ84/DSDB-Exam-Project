package dsdb.logger.Repository;

import dsdb.logger.Model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Song, Integer> {
}
