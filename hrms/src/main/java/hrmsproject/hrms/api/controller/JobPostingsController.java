package hrmsproject.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobPostingService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.dtos.JobPostingDetailsDto;

@RestController
@RequestMapping("api/jobpostings/")
public class JobPostingsController {

	private JobPostingService jobPostingService;	
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}	
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosting jobPosting) {		
		return ResponseEntity.ok(this.jobPostingService.add(jobPosting));
	}
	
	@PostMapping("update")
	public ResponseEntity<?>update(@Valid @RequestBody JobPosting jobPosting){		
		return ResponseEntity.ok(this.jobPostingService.update(jobPosting));
	}	
	
	@PostMapping("updateisactive")
	public Result updateIsActive(boolean isActive, int id) {		
		return this.jobPostingService.updateIsActive(isActive, id);
	}
	
	@PostMapping("delete")
	public ResponseEntity<?>delete(@RequestBody JobPosting jobPosting) {		
		return ResponseEntity.ok(this.jobPostingService.delete(jobPosting));
	}	
	
	@GetMapping("findByAppDeadlineAfterAndIsActive")
	public DataResult<List<JobPostingDetailsDto>> findByAppDeadlineAfterAndIsActive() {		
		return this.jobPostingService.findByAppDeadlineAfterAndIsActive();
	}	
	
	@GetMapping("sortedAllJobPostingWithAppDeadLineIsActive")
	public DataResult<List<JobPostingDetailsDto>> sortedAllJobPostingWithAppDeadLineIsActive() {		
		return this.jobPostingService.sortedAllJobPostingWithAppDeadLineIsActive();
	}	
	
	@GetMapping("findAllbyemployeridandisactive")
	public DataResult<List<JobPostingDetailsDto>> findAllJobPostingByEmployerId(@RequestParam int employerId) {		
		return this.jobPostingService.findAllJobPostingByEmployerId(employerId);
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