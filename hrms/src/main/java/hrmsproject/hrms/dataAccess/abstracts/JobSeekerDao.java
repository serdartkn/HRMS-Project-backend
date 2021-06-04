package hrmsproject.hrms.dataAccess.abstracts;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
		
	Boolean existsBynationalityId(String nationalityId);
	
	@Modifying
    @Transactional
    @Query("update JobSeeker j set j.eMail=:mail, j.password=:password, j.firstName=:firstName, j.lastName=:lastName, j.dateOfBirth=:dateOfBirth where j.id=:id")
    void updatePosition(String mail, String password, String firstName, String lastName, LocalDate dateOfBirth, int id);

}
