package hrmsproject.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.dtos.JobPostingDetailsDto;

public interface JobPostingService {
	
	DataResult<List<JobPostingDetailsDto>> findByAppDeadlineAfterAndIsActive();
	
	DataResult<List<JobPostingDetailsDto>> sortedAllJobPostingWithAppDeadLineIsActive();
	
	DataResult<List<JobPostingDetailsDto>> findAllJobPostingByEmployerId(int id);
	
	Result add(JobPosting jobPosting);	
	
	Result updateJobPosting(int jobPositionId,String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id);
	
	Result deleteJobPosting(JobPosting jobPosting);
	
	Result updateIsActive(int id);	
}