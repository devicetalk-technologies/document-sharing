package in.co.devicetalk.documentsharing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT u FROM User u WHERE u.student.emailId = ?1 and u.password =?2")
	Optional<User> findUser(String userName,String password);

}
