package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.User;

public interface UserService{
	
	User findById(int id);
	
	Boolean existsByEmail(String email);
	
	Result updateEmailById(String email, String currentPassword, int id);
	
	Result updatePasswordById(String password, String currentPassword, int id);
	
}