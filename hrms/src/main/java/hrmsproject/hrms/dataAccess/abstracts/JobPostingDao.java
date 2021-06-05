package hrmsproject.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	List<JobPosting> findAllSortedByIsActiveAndAppDeadlineAfter(Sort sort, Boolean isActive, LocalDate date);
	List<JobPosting> findAllByEmployer_IdAndIsActiveAndAppDeadlineAfter(int employerId, Boolean isActive, LocalDate date);	
	List<JobPosting> findByAppDeadlineAfterAndIsActive(LocalDate date, Boolean isActive);
	
	@Modifying
    @Transactional
    @Query("update JobPosting j set j.jobPositionId=:jobPositionId, j.desciription=:desciription, j.cityId=:cityId, j.minSalary=:minSalary, j.maxSalary=:maxSalary, j.quato=:quato, j.appDeadline=:appDeadline where j.id=:id")
    void updateJobPosting(int jobPositionId, String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id);
		
	@Modifying
    @Transactional
    @Query("update JobPosting j set j.isActive=:active where j.id=:id")
    void updateIsActive(boolean active, int id);
	
	
    

}