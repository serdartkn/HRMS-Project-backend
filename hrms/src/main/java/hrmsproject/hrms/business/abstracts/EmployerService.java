package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.business.CrudOperationRepo;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employer;

public interface EmployerService extends CrudOperationRepo<Employer>{	
	
	Result updateMailIsVerified(boolean mailIsVerified, int id);
	
	Result updateMngIsVerified(boolean mngIsVerified, int id);	
	
	Result updateCompanyWebSiteAndEmail(Employer employer);
	
	Result updateCompanyNameAndPhone(Employer employer);
	
}