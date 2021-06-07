package hrmsproject.hrms.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobPostingService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
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
	
	@GetMapping("findByAppDeadlineAfterAndIsActive")
	public DataResult<List<JobPostingDetailsDto>> findByAppDeadlineAfterAndIsActive() {		
		return this.jobPostingService.findByAppDeadlineAfterAndIsActive();
	}	
	
	@GetMapping("sortedAllJobPostingWithAppDeadLineIsActive")
	public DataResult<List<JobPostingDetailsDto>> sortedAllJobPostingWithAppDeadLineIsActive() {		
		return this.jobPostingService.sortedAllJobPostingWithAppDeadLineIsActive();
	}	
	
	@GetMapping("findallbyemployeridandisactive")
	public DataResult<List<JobPostingDetailsDto>> findAllJobPostingByEmployerId(@RequestParam int employerId) {		
		return this.jobPostingService.findAllJobPostingByEmployerId(employerId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobPosting jobPosting) {		
		return this.jobPostingService.add(jobPosting);
	}	
	


	

	
//	@PostMapping("updateisactive")
//	public Result updateIsActive(@RequestBody int id) {		
//		return this.jobPostingService.updateIsActive(id);		
//	}
//	
//	@PostMapping("update")
//	public Result update(@RequestBody int jobPositionId, @RequestBody String desciription, @RequestBody int cityId, @RequestBody int minSalary, @RequestBody int maxSalary, @RequestBody int quato, @RequestBody LocalDate appDeadline, @RequestBody int id) {		
//		return this.jobPostingService.updateJobPosting(jobPositionId, desciription, cityId, minSalary, maxSalary, quato, appDeadline, id);
//	}
//	
//	@PostMapping("delete")
//	public Result delete(@RequestBody JobPosting jobPosting) {		
//		return this.jobPostingService.deleteJobPosting(jobPosting);
//	}
	
//	@GetMapping("getJobPostingDetailsDto")
//	public DataResult<List<JobPosting>> getJobPostingDetailsDto() {
//		return this.jobPostingService.getJobPostingDetailsDto();
//		
//	}
}