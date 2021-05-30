package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
	
}
