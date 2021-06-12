package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
		
	Boolean existsBynationalityId(String nationalityId);

	@Modifying
	@Transactional
	@Query("update JobSeeker j set j.mailIsVerified=:mailIsVerified where j.id=:id")
	void updateMailIsVerified(boolean mailIsVerified, int id);	

}