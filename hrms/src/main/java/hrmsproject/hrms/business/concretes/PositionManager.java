package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.PositionService;
import hrmsproject.hrms.business.businessRules.Rules;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
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
	public Result add(Position position) {
		
		if (Rules.checkPositionName(position.getName()) && existsByName(position.getName())!=true) {
			
			this.positionDao.save(position);
			return new SuccessResult(Messages.addedPosition);
		}
		else {
			if (existsByName(position.getName())) {
				
				return new ErrorResult(Messages.errorRegisteredPosition);
			}
		}
		return new ErrorResult(Messages.errorPositionName);
	}
	

	@Override
	public DataResult<List<Position>> getAll() {
		
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "İş Posizyonları Listelendi"); 
	}


	@Override
	public Boolean existsByName(String name) {
		
		if (this.positionDao.existsByName(name)) {
			
			return true;			
		}
		return false;
		
		
	}	

	@Override
	public Result updatePosition(String name, int id) {
		
		if (Rules.checkPositionName(name) && existsByName(name)!=true) {
			
			this.positionDao.updatePosition(name,id);
			return new SuccessResult(Messages.updatedPosition);
		}
		else {
			if (existsByName(name)) {
				
				return new ErrorResult(Messages.errorRegisteredPosition);
			}
		}
		return new ErrorResult(Messages.errorPositionName);
	}

	@Override
	public Result deletePosition(Position position) {
		this.positionDao.delete(position);
		return new SuccessResult(Messages.deletedPosition);
	}
	
}