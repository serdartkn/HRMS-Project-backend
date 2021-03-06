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

import hrmsproject.hrms.business.abstracts.JobSeekerService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add (@Valid @RequestBody JobSeeker jobSeeker){		
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));		
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestBody JobSeeker jobSeeker) {		
		return ResponseEntity.ok(this.jobSeekerService.delete(jobSeeker));
	}

	@GetMapping("findAll")
	public DataResult<List<JobSeeker>> findAll() {		
		return this.jobSeekerService.findAll();
	}
	
	@GetMapping("findById")
	public DataResult<Optional<JobSeeker>> findById(int id) {		
		return this.jobSeekerService.findById(id);
	}
	
	@PostMapping("updateMailIsVerified")
	public Result updateMailIsVerified(boolean mailIsVerified, @RequestBody int id) {		
		return this.jobSeekerService.updateMailIsVerified(mailIsVerified, id);
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