package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.User;

public interface UserService {
	
	Result add(User user);
	DataResult<List<User>> getAll();
	Boolean existsByeMail(String eMail);
}
