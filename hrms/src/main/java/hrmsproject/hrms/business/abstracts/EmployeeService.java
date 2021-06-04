package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employee;

public interface EmployeeService {

	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
	Result updateEmployee(String password, String email, String firstName, String lastName, int id);
	Result deleteEmployee(Employee employee);
}
