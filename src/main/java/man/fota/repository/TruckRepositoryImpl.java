package man.fota.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import man.fota.entity.Artifact;
import man.fota.entity.FeatureRequirement;
import man.fota.entity.Truck;
import man.fota.util.ArtifactMode;

@Repository  
public class TruckRepositoryImpl implements TruckCustomizedRepository {  

	@Autowired
	EntityManager em;

	@Override
	public List<Truck> findByArtifact(String code, ArtifactMode mode){

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Truck> criteriaQuery = cb.createQuery(Truck.class);
		Root<Truck> rootTruck = criteriaQuery.from(Truck.class);

		Join<Truck, FeatureRequirement> featureRequirement = rootTruck.join("feature");

		Predicate predicateAll = null;
		
		if(mode == ArtifactMode.INCOMPATIBLE) {
			
			SetJoin<FeatureRequirement, Artifact> incompatibles = featureRequirement.joinSet("forbiddenArtifact", JoinType.LEFT);
			predicateAll = cb.equal(incompatibles.get("code"), code);
		
		} else if(mode == ArtifactMode.INSTALLABLE) {
			
			SetJoin<FeatureRequirement, Artifact> installables = featureRequirement.joinSet("requiredArtifact", JoinType.LEFT);
			predicateAll = cb.equal(installables.get("code"), code);
		
		} else if(mode == ArtifactMode.ALL) {
			
			SetJoin<FeatureRequirement, Artifact> incompatibles = featureRequirement.joinSet("forbiddenArtifact", JoinType.LEFT);
			SetJoin<FeatureRequirement, Artifact> installables = featureRequirement.joinSet("requiredArtifact", JoinType.LEFT);
			
			Predicate incompatiblesPredicate = cb.equal(incompatibles.get("code"), code);
			Predicate installablesPredicate = cb.equal(installables.get("code"), code);
			
			predicateAll = cb.equal(installables.get("code"), code);
			predicateAll = cb.or(installablesPredicate, incompatiblesPredicate);
		}
		
		criteriaQuery.select(rootTruck).where(predicateAll).distinct(true);

		TypedQuery<Truck> query = em.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

}