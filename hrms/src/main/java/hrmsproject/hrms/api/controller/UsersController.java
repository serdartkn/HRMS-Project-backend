package hrmsproject.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

	private UserService userService;
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("updateEmailById")
	public Result updateEmailById(@RequestBody String email, String currentPassword, int id) {		
		return this.userService.updateEmailById(email, currentPassword, id);
	}
	
	@PostMapping("updatePasswordById")
	public Result updatePasswordById(@RequestBody String password, String currentPassword, int id) {		
		return this.userService.updatePasswordById(password, currentPassword, id);
	}	
	
}