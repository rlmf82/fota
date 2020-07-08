package man.fota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import man.fota.entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long>, TruckCustomizedRepository{  

	@Query("SELECT t FROM Truck t WHERE upper(t.VIN) = upper(:VIN)")
	Optional<Truck> findByVin(@Param("VIN") String vin);
	
}