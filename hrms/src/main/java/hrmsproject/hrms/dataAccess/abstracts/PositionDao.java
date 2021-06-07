package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer>{
	
	Boolean existsByName(String name);
	
	@Modifying
    @Transactional
    @Query("update Position p set p.name=:name where p.id=:id")
    void updatePosition(String name, int id);	
}