package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class ErrorDataResult<T> extends DataResult<T>{

	@Autowired
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	
	@Autowired
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	@Autowired
	public ErrorDataResult( String message) {
		super(null, false, message);
	}
	
	@Autowired
	public ErrorDataResult() {
		super(null, false);
	}
}