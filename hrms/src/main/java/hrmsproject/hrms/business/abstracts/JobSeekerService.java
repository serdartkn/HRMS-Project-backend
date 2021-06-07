package hrmsproject.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobSeeker;
import hrmsproject.hrms.entities.concretes.Position;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	
	Boolean existsByNationalityId(String eMail);
	
	Result updateJobSeeker(String mail, String password, String firstName, String lastName, LocalDate dateOfBirth, int id);
	
	Result deleteJobSeeker(JobSeeker jobSeeker);
}