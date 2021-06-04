package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
	Result updateEmployer(String mail, String password, String companyName, String webSite, String phone, int id);
	Result deleteEmployer(Employer employer);
	
}
