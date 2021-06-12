package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.business.CrudOperationRepo;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.dtos.JobPostingDetailsDto;

public interface JobPostingService extends CrudOperationRepo<JobPosting>{
	
	DataResult<List<JobPostingDetailsDto>> findByAppDeadlineAfterAndIsActive();
		
	DataResult<List<JobPostingDetailsDto>> sortedAllJobPostingWithAppDeadLineIsActive();
	
	DataResult<List<JobPostingDetailsDto>> findAllJobPostingByEmployerId(int id);
		
	Result updateIsActive(boolean isActive, int id);
	
}