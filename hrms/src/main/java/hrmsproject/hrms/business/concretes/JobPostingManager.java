package hrmsproject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.JobPostingService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobPostingDao;
import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.dtos.JobPostingDetailsDto;

@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}
	
	@Override
	public DataResult<List<JobPostingDetailsDto>> findByAppDeadlineAfterAndIsActive() {
		return new SuccessDataResult<List<JobPostingDetailsDto>>(this.jobPostingDao.findByAppDeadlineAfterAndIsActive(), Messages.listedJobPosting);
	}
	
	@Override
	public DataResult<List<JobPostingDetailsDto>> sortedAllJobPostingWithAppDeadLineIsActive() {		
		return new SuccessDataResult<List<JobPostingDetailsDto>>(this.jobPostingDao.sortedAllJobPostingWithAppDeadLineIsActive(), Messages.listedJobPosting);
	}	

	@Override
	public DataResult<List<JobPostingDetailsDto>> findAllJobPostingByEmployerId(int id) {		
		return new SuccessDataResult<List<JobPostingDetailsDto>>(this.jobPostingDao.findAllJobPostingByEmployerId(id), Messages.listedJobPosting);
	}
	
	@Override
	public Result add(JobPosting jobPosting) {		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.addedJobPosting);		
	}

	@Override
	public Result updateIsActive(int id) {		
		this.jobPostingDao.updateIsActive(false,id);
		return new SuccessResult(Messages.updatedJobPosting);		
	}

	@Override
	public Result updateJobPosting(int jobPositionId, String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id) {
		this.jobPostingDao.updateJobPosting(jobPositionId, desciription, cityId, minSalary, maxSalary, quato, appDeadline, id);
		return new SuccessResult(Messages.updatedJobPosting);		
	}

	@Override
	public Result deleteJobPosting(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult(Messages.deletedJobPosting);		
	}
	
}