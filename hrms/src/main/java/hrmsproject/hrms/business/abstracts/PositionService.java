package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Position;

public interface PositionService {
	
	Result add(Position position);
	
	DataResult<List<Position>> getAll();
	
	Boolean existsByName(String name);
	
	Result updatePosition(String name, int id);
	
	Result deletePosition(Position position);
}