package dsdb.features.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dsdb.features.model.AudioFeatures;

@Repository
public interface FeatureRepository extends JpaRepository<AudioFeatures, Integer> {

}
