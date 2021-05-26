package hrmsproject.hrms.business.concretes;

import hrmsproject.hrms.business.abstracts.PersonCheckService;
import hrmsproject.hrms.entities.concretes.JobSeeker;

public class PersonCheckManager implements PersonCheckService {

	@Override
	public boolean ifCheckRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}
