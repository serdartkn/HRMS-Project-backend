package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class ErrorResult extends Result {
	
	@Autowired
	public ErrorResult() {
		super(false);
	}
	
	@Autowired
	public ErrorResult(String message){
		super(false, message);
	}
}