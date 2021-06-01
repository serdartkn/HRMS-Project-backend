package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

import hrmsproject.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> findAllByIsActive();
	DataResult<List<JobPosting>> findAllSortedByIsActive();
	DataResult<List<JobPosting>> findAllByEmployerIdAndIsActive(int employerId);

}
