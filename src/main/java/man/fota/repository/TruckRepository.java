package man.fota.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import man.fota.entity.Truck;

@Repository  
public interface TruckRepository extends JpaRepository<Truck, Long> {  

	@Query("SELECT t FROM Truck t WHERE upper(t.VIN) = upper(:VIN)")
	Optional<Truck> findByVin(@Param("VIN") String vin);
	
	@Query("SELECT DISTINCT t FROM Truck t "
			+ "JOIN t.feature f "
			+ "LEFT JOIN f.requiredArtifact rq "
			+ "LEFT JOIN f.forbiddenArtifact fq "
			+ "WHERE rq.code = :code OR fq.code = :code")
	List<Truck> findByArtifact(@Param("code") String code);
	
}