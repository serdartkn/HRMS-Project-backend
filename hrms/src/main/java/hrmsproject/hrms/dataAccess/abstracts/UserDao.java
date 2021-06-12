package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{	

	User findById(int id);
	
	Boolean existsByEmail(String email);	
	
	@Modifying
	@Transactional
	@Query("update User u "
			+ "set u.email=:email "
			+ "where u.id=:id")
	void updateMailById(String email, int id);
	
	@Modifying
	@Transactional
	@Query("update User u "
			+ "set u.password=:password "
			+ "where u.id=:id")
	void updatePasswordById(String password, int id);	
	
}