package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees/")
public class EmployeesController {
	
	private EmployeeService employeeService;
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Employee employee) {		
		return this.employeeService.add(employee);
	}

	@GetMapping("getall")
	public DataResult<List<Employee>> getAll() {		
		return this.employeeService.getAll();
	}
	
	@PostMapping("update")
	public Result update(String mail, String password, String firstName, String lastName, int id) {		
		return this.employeeService.updateEmployee(mail, password, firstName, lastName, id);
	}
	
	@PostMapping("delete")
	public Result delete(Employee employee) {		
		return this.employeeService.deleteEmployee(employee);
	}
}
