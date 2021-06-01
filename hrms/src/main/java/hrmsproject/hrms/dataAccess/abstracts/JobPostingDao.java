package hrmsproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	List<JobPosting> findAllByIsActive(Boolean isActive);
	List<JobPosting> findAllSortedByIsActive(Sort sort, Boolean isActive);
	List<JobPosting> findAllByEmployer_IdAndIsActive(int employerId, Boolean isActive);
	
}