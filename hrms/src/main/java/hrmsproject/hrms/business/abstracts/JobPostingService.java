package hrmsproject.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

import hrmsproject.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> findAllSortedByDate();
	DataResult<List<JobPosting>> findAllJobPostingByEmployerId(int employerId);
	DataResult<List<JobPosting>> findAll();
	Result updateJobPosting(int jobPositionId,String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id);
	Result deleteJobPosting(JobPosting jobPosting);
	Result updateIsActive(int id);
	
}