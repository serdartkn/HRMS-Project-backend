package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class Result {
	
	private boolean success;
	private String message;
	@Autowired
	public Result(boolean success, String message) {		
		this(success);
		this.message = message;
	}
	
	@Autowired
	public Result(boolean success) {		
		this.success = success;		
	}

	@Autowired
	public boolean isSuccess() {
		return success;
	}

	@Autowired
	public String getMessage() {
		return message;
	}	
}