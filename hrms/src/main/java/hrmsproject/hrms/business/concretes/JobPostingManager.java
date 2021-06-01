package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	public DataResult<List<JobPosting>> findAllByIsActive() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActive(true), Messages.listedJobPosting);
	}

	@Override
	public DataResult<List<JobPosting>> findAllSortedByIsActive() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllSortedByIsActive(sort,true), Messages.listedJobPosting);
	}

	@Override
	public DataResult<List<JobPosting>> findAllByEmployerIdAndIsActive(int employerId) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByEmployer_IdAndIsActive(employerId,true), Messages.listedJobPosting);
	}
	
}