package hrmsproject.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.entities.concretes.Employee;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorDataResult;

@RestController
@RequestMapping("/api/employees/")
public class EmployeesController {
	
	private EmployeeService employeeService;
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {		
		return ResponseEntity.ok(this.employeeService.add(employee));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestBody Employee employee) {		
		return ResponseEntity.ok(this.employeeService.delete(employee));
	}

	@GetMapping("findAll")
	public DataResult<List<Employee>> findAll() {		
		return this.employeeService.findAll();
	}
	
	@GetMapping("findById")
	public DataResult<Optional<Employee>> findById(@RequestParam int id) {		
		return this.employeeService.findById(id);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>(); 		
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
		return errors;
	}

}