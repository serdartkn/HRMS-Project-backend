package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.entities.concretes.JobSeeker;

public interface PersonCheckService {
	
	boolean ifCheckRealPerson(JobSeeker jobSeeker);

}
