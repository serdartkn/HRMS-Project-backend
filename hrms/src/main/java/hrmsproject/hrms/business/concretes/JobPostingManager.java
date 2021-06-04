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

@Service
public class JobPostingManager implements JobPostingService{
	
	JobPostingDao jobPostingDao;

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
	public DataResult<List<JobPosting>> findAllSortedByDate() {
		
		LocalDate nowDate = LocalDate.now();
		Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllSortedByIsActiveAndAppDeadlineAfter(sort,true,nowDate), Messages.listedJobPosting);
	}

	@Override
	public DataResult<List<JobPosting>> findAllJobPostingByEmployerId(int employerId) {
		
		LocalDate nowDate = LocalDate.now();
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByEmployer_IdAndIsActiveAndAppDeadlineAfter(employerId,true,nowDate), Messages.listedJobPosting);
	}

	@Override
	public DataResult<List<JobPosting>> findAll() {

		LocalDate nowDate = LocalDate.now();
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByAppDeadlineAfterAndIsActive(nowDate, true), Messages.listedJobPosting);
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