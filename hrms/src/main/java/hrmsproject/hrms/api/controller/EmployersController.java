package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.EmployerService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
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
	public Result add(@RequestBody Employer employer) {
		
		return this.employersService.add(employer);
	}

	@GetMapping("getall")
	public DataResult<List<Employer>> getAll() {
		
		return this.employersService.getAll();
	}

}
