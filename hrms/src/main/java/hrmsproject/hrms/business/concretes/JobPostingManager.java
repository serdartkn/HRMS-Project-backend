package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Result add(JobPosting jobPosting) {		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.addedJobPosting);		
	}
	
	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.updateJobPosting(jobPosting.getJobPosition().getId(), jobPosting.getDesciription(), jobPosting.getCity().getId(), jobPosting.getMinSalary(), jobPosting.getMaxSalary(), jobPosting.getQuato(), jobPosting.getAppDeadline(), jobPosting.getReleaseDate(), jobPosting.getId());
		return new SuccessResult(Messages.updatedJobPosting);		
	}
	
	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult(Messages.deletedJobPosting);		
	}

	@Override
	public DataResult<List<JobPosting>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Optional<JobPosting>> findById(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Result updateIsActive(boolean isActive, int id) {
		this.jobPostingDao.updateIsActive(isActive,id);
		return new SuccessResult(Messages.updatedJobPosting);
	}

}