package hrmsproject.hrms.api.controller;

import java.time.LocalDate;
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
import hrmsproject.hrms.entities.concretes.Position;


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
	
	@PostMapping("update")
	public Result update(String mail, String password, String firstName, String lastName,@RequestBody LocalDate dateofBirth, int id) {
		
		return this.jobSeekerService.updateJobSeeker(mail, password, firstName, lastName, dateofBirth, id);
	}
	
	@PostMapping("delete")
	public Result delete(JobSeeker jobSeeker) {
		
		return this.jobSeekerService.deleteJobSeeker(jobSeeker);
	}

}