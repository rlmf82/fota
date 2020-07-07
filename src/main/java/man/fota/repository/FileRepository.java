package man.fota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import man.fota.entity.File;

@Repository  
public interface FileRepository extends JpaRepository<File, Long> {  
	
	@Query("SELECT f FROM File f WHERE f.name = :name")
	Optional<File> findByName(@Param("name") String name);
}