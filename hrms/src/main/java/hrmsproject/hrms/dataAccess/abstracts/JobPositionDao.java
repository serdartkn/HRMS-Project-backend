package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	Boolean existsByName(String name);
	
	@Modifying
    @Transactional
    @Query("update JobPosition jp "
    		+ "set jp.name=:name "
    		+ "where jp.id=:id")
    void updateJobPositionName(String name, int id);
	
}