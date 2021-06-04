package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
    @Transactional
    @Modifying
    @Query("update Employee e set e.password=:password, e.eMail=:email, e.firstName=:firstName, e.lastName=:lastName where e.id=:id")
    void updateEmployee(String password, String email, String firstName, String lastName, int id);

}
