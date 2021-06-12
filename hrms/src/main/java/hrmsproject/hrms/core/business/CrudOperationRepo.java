package hrmsproject.hrms.core.business;

import java.util.List;
import java.util.Optional;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;

public interface CrudOperationRepo<T> {
	
	Result add(T entity);
	Result delete (T entity);
	Result update (T entity);
	DataResult<List<T>> findAll();
	DataResult<Optional<T>> findById(int id);
}