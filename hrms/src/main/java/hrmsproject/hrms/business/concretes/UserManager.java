package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
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
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<User>> getAll() {		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),Messages.listedUsers);
	}

	@Override
	public Boolean existsByeMail(String eMail) {		
		return this.userDao.existsByeMail(eMail);	
	}
}