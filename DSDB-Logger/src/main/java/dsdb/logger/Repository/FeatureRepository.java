package dsdb.logger.Repository;

import dsdb.logger.Model.FeaturesInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends MongoRepository<FeaturesInfo, Integer> {

}
