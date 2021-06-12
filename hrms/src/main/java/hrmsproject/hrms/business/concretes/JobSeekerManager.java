package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.JobSeekerService;
import hrmsproject.hrms.business.abstracts.PersonCheckService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.business.utilities.mailSendManager.MailValidationManager;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsproject.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private PersonCheckService personCheckService;	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, PersonCheckService personCheckService, UserService userService) {
		this.jobSeekerDao = jobSeekerDao;
		this.personCheckService = personCheckService;
		this.userService = userService;
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		if(personCheckService.ifCheckRealPerson(jobSeeker) && userService.existsByEmail(jobSeeker.getEmail())!=true && this.existsByNationalityId(jobSeeker.getNationalityId())!=true) {
			this.jobSeekerDao.save(jobSeeker);
			MailValidationManager.sendMail(jobSeeker.getEmail());
			return new SuccessResult(Messages.addedJobSeeker);
		}
		else {
			if (userService.existsByEmail(jobSeeker.getEmail())) {
				return new ErrorResult(Messages.errorRegisteredMail);					
			}			
			else if (this.existsByNationalityId(jobSeeker.getNationalityId())) {
				return new ErrorResult(Messages.errorRegisteredNationalityId);
			}				
		}
		return new ErrorResult(Messages.errorInformation);
	}
	
	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult(Messages.deletedJobSeeker);
	}

	@Override
	public Result update(JobSeeker entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Result updateMailIsVerified(boolean mailIsVerified, int id) {
		this.jobSeekerDao.updateMailIsVerified(mailIsVerified, id);
		return new SuccessResult(Messages.updatedJobSeeker);
	}	

	@Override
	public DataResult<List<JobSeeker>> findAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), Messages.listedJobSeekers);
	}

	@Override
	public DataResult<Optional<JobSeeker>> findById(int id) {
		return new SuccessDataResult<Optional<JobSeeker>>(this.jobSeekerDao.findById(id));
	}

	@Override
	public Boolean existsByNationalityId(String nationalityId) {
		if (this.jobSeekerDao.existsBynationalityId(nationalityId)) {			
			return true;			
		}
		return false;
	}

}