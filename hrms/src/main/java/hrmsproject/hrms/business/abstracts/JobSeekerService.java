package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);	
	Boolean existsByEmail(String eMail);
	Boolean existsByNationalityId(String eMail);

}