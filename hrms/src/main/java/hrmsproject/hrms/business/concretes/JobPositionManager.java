package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.JobPositionService;
import hrmsproject.hrms.business.constants.Messages;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessDataResult;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobPositionDao;
import hrmsproject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		if (existsByName(jobPosition.getName())!=true) {			
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult(Messages.addedPosition);
		}
		else {
			if (existsByName(jobPosition.getName())) {				
				return new ErrorResult(Messages.errorRegisteredPosition);
			}
		}
		return new ErrorResult(Messages.errorPositionName);
	}
	
	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult(Messages.deletedPosition);		
	}
	
	@Override
	public Result update(JobPosition jobPosition) {
		if (existsByName(jobPosition.getName())!=true) {			
			this.jobPositionDao.updateJobPositionName(jobPosition.getName(), jobPosition.getId());
			return new SuccessResult(Messages.updatedPosition);
		}
		else {
			if (existsByName(jobPosition.getName())) {				
				return new ErrorResult(Messages.errorRegisteredPosition);
			}
		}
		return new ErrorResult(Messages.errorPositionName);
	}
		
	@Override
	public DataResult<List<JobPosition>> findAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.listedPositions); 
	}
	
	@Override
	public DataResult<Optional<JobPosition>> findById(int id) {
		return new SuccessDataResult<Optional<JobPosition>>(this.jobPositionDao.findById(id), Messages.listedPositions); 
	}
	
	@Override
	public Boolean existsByName(String name) {
		if (this.jobPositionDao.existsByName(name)) {			
			return true;			
		}
		return false;	
	}	
	
}