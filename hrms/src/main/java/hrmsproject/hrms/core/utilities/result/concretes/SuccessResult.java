package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class SuccessResult extends Result{
	
	@Autowired
	public SuccessResult(){
		super(true);
	}
	
	@Autowired
	public SuccessResult(String message) {
		super(true, message);
	}
	
}