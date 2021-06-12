package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.business.CrudOperationRepo;
import hrmsproject.hrms.entities.concretes.JobPosition;

public interface JobPositionService  extends CrudOperationRepo<JobPosition>{

	Boolean existsByName(String name);
}