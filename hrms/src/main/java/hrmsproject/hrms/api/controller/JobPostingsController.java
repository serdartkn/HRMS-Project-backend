package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobPostingService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("api/jobpostings/")
public class JobPostingsController {

	JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobPosting jobPosting) {
		
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("getallactive")
	public DataResult<List<JobPosting>> findAllByIsActive(@RequestBody Boolean value) {
		
		return this.jobPostingService.findAllByIsActive();
	}
	
	@GetMapping("findallbyisactiveandreleasedate")
	public DataResult<List<JobPosting>> findAllByIsActiveAndReleaseDate() {
		
		return this.jobPostingService.findAllSortedByIsActive();
	}	
	
	
	@PostMapping("findallbyemployeridandisactive")
	public DataResult<List<JobPosting>> findAllByEmployer_EmployerIdAndIsActive(@RequestBody int employerId) {
		
		return this.jobPostingService.findAllByEmployerIdAndIsActive(employerId);
	}
}