package hrmsproject.hrms.core.utilities.result.concretes;

import org.springframework.beans.factory.annotation.Autowired;

public class DataResult<T> extends Result{
	
	private T data;	
	@Autowired
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data=data;
	}
	
	public DataResult(T data,boolean success) {
		super(success);
		this.data=data;
	}

	public T getData() {
		return data;
	}
}