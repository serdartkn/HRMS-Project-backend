package hrmsproject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.JobSeekerService;
import hrmsproject.hrms.business.abstracts.PersonCheckService;
import hrmsproject.hrms.business.businessRules.Rules;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.mailCheck.MailValidationManager;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsproject.hrms.entities.concretes.JobSeeker;
import hrmsproject.hrms.entities.concretes.Position;


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
		
		if(personCheckService.ifCheckRealPerson(jobSeeker) && Rules.checkMail(jobSeeker.getEMail()) && Rules.checkFirstName(jobSeeker.getFirstName())&& Rules.checkLastName(jobSeeker.getLastName()) && Rules.checkNationalityId(jobSeeker.getNationalityId())&& Rules.checkPassword(jobSeeker.getPassword())&&Rules.checkDateOfBirth(jobSeeker.getDateOfBirth())) {
			
			if(userService.existsByeMail(jobSeeker.getEMail())!=true && this.existsByNationalityId(jobSeeker.getNationalityId())!=true) {					
				
				this.jobSeekerDao.save(jobSeeker);
				MailValidationManager.sendMail(jobSeeker.getEMail());
				return new SuccessResult(Messages.addedJobSeeker);
			}
			else {
				
				if (userService.existsByeMail(jobSeeker.getEMail())) {
					
					return new ErrorResult(Messages.errorRegisteredMail);					
				}
				else if (this.existsByNationalityId(jobSeeker.getNationalityId())) {
					
					return new ErrorResult(Messages.errorRegisteredNationalityId);
				}				
			}			
		}
		else {
			
			if (personCheckService.ifCheckRealPerson(jobSeeker)==false) {
				
				return new ErrorResult(Messages.errorInformation);
			}
			else if (Rules.checkMail(jobSeeker.getEMail())==false) {
				
				return new ErrorResult(Messages.errorMail);
			}
			else if (Rules.checkFirstName(jobSeeker.getFirstName())==false || Rules.checkLastName(jobSeeker.getLastName())==false) {
				
				return new ErrorResult(Messages.errorFirstNameOrLastName);
			}
			else if (Rules.checkNationalityId(jobSeeker.getNationalityId())==false) {
				
				return new ErrorResult(Messages.errorNationalityId);
			}
			else if (Rules.checkPassword(jobSeeker.getPassword())==false) {
				
				return new ErrorResult(Messages.errorPassword);
			}
			else if (Rules.checkDateOfBirth(jobSeeker.getDateOfBirth())==false) {
				
				return new ErrorResult(Messages.errorDateOfBirth);
			}
		}				
		
		return new ErrorResult(Messages.errorInformation);		
	}
	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), Messages.listedJobSeekers);
	}
	

	@Override
	public Boolean existsByNationalityId(String nationalityId) {
		
		if (this.jobSeekerDao.existsBynationalityId(nationalityId)) {
			
			return true;			
		}
		return false;		
	}


	@Override
	public Result updateJobSeeker(String mail, String password, String firstName, String lastName,
			LocalDate dateOfBirth, int id) {
		
		if(Rules.checkMail(mail) && Rules.checkFirstName(firstName)&& Rules.checkLastName(lastName) &&  Rules.checkPassword(password)&&Rules.checkDateOfBirth(dateOfBirth)) {
			
			if(userService.existsByeMail(mail)!=true) {					
				
				this.jobSeekerDao.updateJobSeeker(mail, password, firstName, lastName, dateOfBirth, id);
				return new SuccessResult(Messages.updatedJobSeeker);
			}
			else {
				
				if (userService.existsByeMail(mail)) {
					
					return new ErrorResult(Messages.errorRegisteredMail);					
				}			
			}			
		}
		else {
			
			if (Rules.checkMail(mail)==false) {
				
				return new ErrorResult(Messages.errorMail);
			}
			else if (Rules.checkFirstName(firstName)==false || Rules.checkLastName(lastName)==false) {
				
				return new ErrorResult(Messages.errorFirstNameOrLastName);
			}
			else if (Rules.checkPassword(password)==false) {
				
				return new ErrorResult(Messages.errorPassword);
			}
			else if (Rules.checkDateOfBirth(dateOfBirth)==false) {
				
				return new ErrorResult(Messages.errorDateOfBirth);
			}
		}				
		
		return new ErrorResult(Messages.errorInformation);		
	}


	@Override
	public Result deleteJobSeeker(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult(Messages.deletedJobSeeker);
	}	
}