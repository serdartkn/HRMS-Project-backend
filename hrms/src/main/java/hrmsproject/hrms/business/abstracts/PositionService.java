package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.entities.concretes.Position;

public interface PositionService {
	
	DataResult<List<Position>> getAll();

}
