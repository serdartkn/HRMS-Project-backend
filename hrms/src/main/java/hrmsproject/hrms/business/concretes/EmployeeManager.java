package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.business.businessRules.Rules;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee employee) {
		
		if (Rules.checkMail(employee.getEMail()) && Rules.checkFirstName(employee.getFirstName()) && Rules.checkLastName(employee.getLastName()) && Rules.checkPassword(employee.getPassword())) {
			
			this.employeeDao.save(employee);
			return new SuccessResult(Messages.addedEmployee);			
		}
		else {
			
			if (Rules.checkMail(employee.getEMail())==false) {
				
				return new ErrorResult(Messages.errorMail);
			}
			else if (Rules.checkFirstName(employee.getFirstName())==false || Rules.checkLastName(employee.getLastName())==false) {
				
				return new ErrorResult(Messages.errorFirstNameOrLastName);
			}
			else if (Rules.checkPassword(employee.getPassword())==false) {
				
				return new ErrorResult(Messages.errorPassword);
			}			
		}
		return new ErrorResult(Messages.errorInformation);

	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), Messages.listedEmployees);
	}

	@Override
	public Result updateEmployee(String password, String email, String firstName, String lastName, int id) {
		if (Rules.checkMail(email) && Rules.checkFirstName(firstName) && Rules.checkLastName(lastName) && Rules.checkPassword(password)) {
			
			this.employeeDao.updateEmployee(password, email, firstName, lastName, id);;
			return new SuccessResult(Messages.updatedEmployee);			
		}
		else {
			
			if (Rules.checkMail(email)==false) {
				
				return new ErrorResult(Messages.errorMail);
			}
			else if (Rules.checkFirstName(firstName)==false || Rules.checkLastName(lastName)==false) {
				
				return new ErrorResult(Messages.errorFirstNameOrLastName);
			}
			else if (Rules.checkPassword(password)==false) {
				
				return new ErrorResult(Messages.errorPassword);
			}			
		}
		return new ErrorResult(Messages.errorInformation);
	}

	@Override
	public Result deleteEmployee(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult(Messages.updatedEmployee);		
	}

}
