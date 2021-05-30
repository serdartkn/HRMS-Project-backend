package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer>{
	
	Boolean existsByName(String name);

}
