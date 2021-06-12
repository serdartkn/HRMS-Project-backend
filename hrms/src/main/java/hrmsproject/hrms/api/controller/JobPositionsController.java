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

import hrmsproject.hrms.business.abstracts.JobPositionService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorDataResult;
import hrmsproject.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/positions/")
public class JobPositionsController{
	
	private JobPositionService jobPositionService;	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition) {		
		return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestBody JobPosition jobPosition) {		
		return ResponseEntity.ok(this.jobPositionService.delete(jobPosition));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody JobPosition jobPosition) {		
		return ResponseEntity.ok(this.jobPositionService.update(jobPosition));
	}
	
	@GetMapping("findAll")
	public DataResult<List<JobPosition>>findAll(){		
		return this.jobPositionService.findAll();		
	}
	
	@GetMapping("findById")
	public DataResult<Optional<JobPosition>>findById(@RequestParam int id){		
		return this.jobPositionService.findById(id);		
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