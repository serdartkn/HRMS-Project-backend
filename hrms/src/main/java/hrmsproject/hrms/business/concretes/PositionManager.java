package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.PositionService;
import hrmsproject.hrms.dataAccess.abstracts.PositionDao;
import hrmsproject.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	PositionDao positionDao;	
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}


	@Override
	public List<Position> getAll() {
		
		return this.positionDao.findAll();
	}

}
