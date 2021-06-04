package hrmsproject.hrms.api.controller;

import java.time.LocalDate;
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
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.concretes.JobSeeker;

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
	
	@GetMapping("findallbyisactiveandreleasedate")
	public DataResult<List<JobPosting>> findAllSortedByDate() {		
		return this.jobPostingService.findAllSortedByDate();
	}	
	
	@PostMapping("findallbyemployeridandisactive")
	public DataResult<List<JobPosting>> findAllJobPostingByEmployerId(@RequestBody int employerId) {		
		return this.jobPostingService.findAllJobPostingByEmployerId(employerId);
	}
	
	@GetMapping("getallactive")
	public DataResult<List<JobPosting>> findByAppDeadlineAfterAndIsActive() {
		return this.jobPostingService.findAll();
	}
	
	@PostMapping("updateisactive")
	public Result updateIsActive(@RequestBody int id) {		
		return this.jobPostingService.updateIsActive(id);		
	}
	
	@PostMapping("update")
	public Result update(int jobPositionId, String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id) {		
		return this.jobPostingService.updateJobPosting(jobPositionId, desciription, cityId, minSalary, maxSalary, quato, appDeadline, id);
	}
	
	@PostMapping("delete")
	public Result delete(JobPosting jobPosting) {		
		return this.jobPostingService.deleteJobPosting(jobPosting);
	}
}