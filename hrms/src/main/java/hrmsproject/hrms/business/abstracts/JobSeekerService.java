package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.business.CrudOperationRepo;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService  extends CrudOperationRepo<JobSeeker>{
	
	Boolean existsByNationalityId(String nationalityId);
	
	Result 	updateMailIsVerified(boolean mailIsVerified, int id);
	
}