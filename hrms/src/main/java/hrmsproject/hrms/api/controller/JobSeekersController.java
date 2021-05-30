package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobSeekerService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.JobSeeker;


@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {
	
	JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	

	@GetMapping("getall")
	public DataResult<List<JobSeeker>> getAll() {
		
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody JobSeeker jobSeeker){
		
		return this.jobSeekerService.add(jobSeeker);		
	}

}