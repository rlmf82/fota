package man.fota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import man.fota.entity.User;

@Repository  
public interface UserRepository extends JpaRepository<User, Long> {  

	@Query("SELECT u FROM User u WHERE upper(u.login) = upper(:login)")
	Optional<User> exist(@Param("login") String login);
	
	@Query("SELECT u FROM User u WHERE u.login = :login")
	User findByLogin(@Param("login") String login);
	
}