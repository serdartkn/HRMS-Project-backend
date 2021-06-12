package hrmsproject.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.EmployerService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {
	
	private EmployerService employersService;
	@Autowired
	public EmployersController(EmployerService employersService) {
		this.employersService = employersService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {		
		return ResponseEntity.ok(this.employersService.add(employer));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestBody Employer employer) {		
		return ResponseEntity.ok(this.employersService.delete(employer));
	}
	
	@PostMapping("updateCompanyWebSiteAndEmail")
	public ResponseEntity<?> updateCompanyWebSiteAndEmail(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employersService.update(employer));
	}
	
	@PostMapping("updateCompanyNameAndPhone")
	public ResponseEntity<?> updateCompanyNameAndPhone(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employersService.update(employer));
	}
	
	@PostMapping("updateMailIsVerified")
	public Result updateMailIsVerified(boolean mailIsVerified, int id) {
		return this.employersService.updateMailIsVerified(mailIsVerified, id);
	}
	
	@PostMapping("updateMngIsVerified")
	public Result updateMngIsVerified(boolean mngIsVerified, int id) {
		return this.employersService.updateMngIsVerified(mngIsVerified, id);
	}	

	@GetMapping("findAll")
	public DataResult<List<Employer>> findAll() {		
		return this.employersService.findAll();
	}
	
	@GetMapping("findById")
	public DataResult<Optional<Employer>> findById(int id) {		
		return this.employersService.findById(id);
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