package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsproject.hrms.dataAccess.abstracts.UserDao;
import hrmsproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private UserDao userDao;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UserDao userDao) {
		this.employeeDao = employeeDao;
		this.userDao=userDao;
	}
	
	@Override
	public Result add(Employee employee) {		
		if (userDao.existsByEmail(employee.getEmail())!=true) {
			this.employeeDao.save(employee);
			return new SuccessResult(Messages.addedEmployee);			
		}
		return new ErrorResult(Messages.errorRegisteredMail);
	}
	
	@Override
	public Result update(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult(Messages.updatedEmployee);		
	}
	
	@Override
	public DataResult<List<Employee>> findAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), Messages.listedEmployees);
	}
		
	@Override
	public DataResult<Optional<Employee>> findById(int id) {
		return new SuccessDataResult<Optional<Employee>>(this.employeeDao.findById(id), Messages.listedEmployees);
	}
	
}