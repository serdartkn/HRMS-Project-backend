package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.EmployerService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.business.utilities.businessRules.Rules;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
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
		if (userService.existsByEmail(employer.getEmail())!=true && Rules.checkCompanyMail(employer.getWebSite(), employer.getEmail())) {
			this.employerDao.save(employer);
			return new SuccessResult(Messages.addedEmployer);
		}
		else {
			if (userService.existsByEmail(employer.getEmail())) {
				return new ErrorResult(Messages.errorRegisteredMail);					
			}
			else if (!Rules.checkCompanyMail(employer.getWebSite(), employer.getEmail())) {
				return new ErrorResult(Messages.errorCompanyMail);					
			}
		}
		return new ErrorResult(Messages.errorInformation);		
	}
	
	@Override
	public Result delete(Employer employer) {		
		this.employerDao.delete(employer);
		return new SuccessResult(Messages.updatedEmployer);		
	}
	
	@Override
	public Result update(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Result updateCompanyWebSiteAndEmail(Employer employer) {
		if (!userService.existsByEmail(employer.getEmail()) && Rules.checkCompanyMail(employer.getWebSite(), employer.getEmail())) {
		    this.employerDao.updateCompanyWebSiteAndEmail(employer.getEmail(), employer.getWebSite(), employer.getId());
		    return new SuccessResult(Messages.updatedEmployer);
			}
			else {
				if (userService.existsByEmail(employer.getEmail())) {
					return new ErrorResult(Messages.errorRegisteredMail);					
				}
				else if (!Rules.checkCompanyMail(employer.getWebSite(), employer.getEmail())) {
					return new ErrorResult(Messages.errorCompanyMail);					
				}
			}
			return new ErrorResult(Messages.errorInformation);
	}

	@Override
	public Result updateCompanyNameAndPhone(Employer employer) {
		    this.employerDao.updateCompanyNameAndPhone(employer.getCompanyName(), employer.getPhone(), employer.getId());
		    return new SuccessResult(Messages.updatedEmployer);
	}
	
	@Override
	public Result updateMailIsVerified(boolean mailIsVerified, int id) {
    this.employerDao.updateMailIsVerified(mailIsVerified, id);
    return new SuccessResult(Messages.updatedEmployer);
	}

	@Override
	public Result updateMngIsVerified(boolean mngIsVerified, int id) {
	    this.employerDao.updateMngIsVerified(mngIsVerified, id);
	    return new SuccessResult(Messages.updatedEmployer);
	}

	@Override
	public DataResult<List<Employer>> findAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.listedEmployers);
	}

	@Override
	public DataResult<Optional<Employer>> findById(int id) {
		return new SuccessDataResult<Optional<Employer>>(this.employerDao.findById(id), Messages.listedEmployers);
	}
	
}