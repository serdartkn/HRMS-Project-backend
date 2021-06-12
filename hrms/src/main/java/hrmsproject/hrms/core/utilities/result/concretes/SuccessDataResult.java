package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class SuccessDataResult<T> extends DataResult<T>{

	@Autowired
	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	@Autowired
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
}