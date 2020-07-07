package man.fota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import man.fota.entity.FeatureRequirement;

@Repository  
public interface FeatureRepository extends JpaRepository<FeatureRequirement, Long> {  

}