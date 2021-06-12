package hrmsproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.business.utilities.businessRules.Rules;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.UserDao;
import hrmsproject.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Result updateEmailById(String email, String currentPassword, int id) {
		if (this.findById(id).getPassword().equals(currentPassword) && !this.existsByEmail(email) && Rules.checkMail(email)){
			userDao.updateMailById(email, id);
			return new SuccessResult(Messages.updatedEmail);
		}
		else {
			if (this.existsByEmail(email)) {
				return new ErrorResult(Messages.errorRegisteredMail);
			}
			else if (!this.findById(id).getPassword().equals(currentPassword)) {
				return new ErrorResult(Messages.errorWrongPassword);
			}
			else if (!Rules.checkMail(email)) {
				return new ErrorResult(Messages.errorMail);
			}	
		}
		return new ErrorResult(Messages.errorInformation);		
	}
	
	@Override
	public Result updatePasswordById(String password, String currentPassword, int id) {
		if (this.findById(id).getPassword().equals(currentPassword) && !this.findById(id).getPassword().equals(password) && Rules.checkPassword(password)){
			userDao.updatePasswordById(password, id);
			return new SuccessResult(Messages.updatedPassword);
		}
		else {
			if (this.findById(id).getPassword().equals(password)) {
				return new ErrorResult(Messages.errorSamePassword);
			}
			else if (!Rules.checkPassword(password)) {
				return new ErrorResult(Messages.errorPassword);
			}
			else if (!this.findById(id).getPassword().equals(currentPassword)) {
				return new ErrorResult(Messages.errorWrongPassword);
			}
		}
		return new ErrorResult(Messages.errorInformation);	
	}
	
	@Override
	public User findById(int id) {
		return this.userDao.findById(id);
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		return this.userDao.existsByEmail(email);
	}

}