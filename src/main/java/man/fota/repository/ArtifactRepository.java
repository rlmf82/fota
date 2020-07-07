package man.fota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import man.fota.entity.Artifact;

@Repository  
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {  

	@Query("SELECT a FROM Artifact a WHERE a.code = :code")
	Optional<Artifact> findByCode(@Param("code") String code);
	
}