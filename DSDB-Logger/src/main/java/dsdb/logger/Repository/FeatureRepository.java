package dsdb.logger.Repository;

import dsdb.logger.Model.AudioFeatures;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends MongoRepository<AudioFeatures, Integer> {
}
