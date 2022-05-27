package dsdb.logger.Repository;

import dsdb.logger.Model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<Session, Integer> {
}
