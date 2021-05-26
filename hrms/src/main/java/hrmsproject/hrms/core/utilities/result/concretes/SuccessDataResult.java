package hrmsproject.hrms.core.utilities.result.concretes;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
	}
}