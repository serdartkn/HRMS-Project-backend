package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.EmployerService;
import hrmsproject.hrms.business.businessRules.Rules;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.UserDao;
import hrmsproject.hrms.dataAccess.abstracts.EmployerDao;
import hrmsproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {
		
		this.employerDao = employerDao;
		this.userService = userService;
	}

	@Override
	public Result add(Employer employer) {
		
		if (Rules.checkMail(employer.getEMail()) && Rules.checkCompanyName(employer.getCompanyName()) && Rules.checkPassword(employer.getPassword()) && Rules.checkPhone(employer.getPhone()) && Rules.checkWebSite(employer.getWebSite())) {
			
			if (userService.existsByeMail(employer.getEMail())!=true) {
				
				this.employerDao.save(employer);
				return new SuccessResult(Messages.addedEmployer);
			}else {
				
				return new ErrorResult(Messages.errorRegisteredMail);				
			}			
		}
		else {
			
			if (Rules.checkMail(employer.getEMail())==false) {
				
				return new ErrorResult(Messages.errorMail);	
			}
			else if (Rules.checkCompanyName(employer.getCompanyName())==false) {
				
				return new ErrorResult(Messages.errorCompanyName);	
			}
			else if (Rules.checkWebSite(employer.getWebSite())==false) {
				
				return new ErrorResult(Messages.errorWebSite);	
			}
			else if (Rules.checkPassword(employer.getPassword())==false) {
				
				return new ErrorResult(Messages.errorPassword);	
			}
			else if (Rules.checkPhone(employer.getPhone())==false) {
				
				return new ErrorResult(Messages.errorPhone);	
			}
		}
		return new ErrorResult(Messages.errorInformation);
	}	

	@Override
	public DataResult<List<Employer>> getAll() {		
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.listedEmployers);
	}

}