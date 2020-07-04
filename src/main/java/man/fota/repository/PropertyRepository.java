package man.fota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import man.fota.entity.Property;
import man.fota.entity.PropertyKeyEnum;

@Repository  
public interface PropertyRepository extends JpaRepository<Property, PropertyKeyEnum> {  

}