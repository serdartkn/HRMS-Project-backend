package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.PositionService;
import hrmsproject.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	PositionService positionsService;
	
	@Autowired
	public PositionsController(PositionService positionService) {		
		this.positionsService = positionService;
	}
	
	@GetMapping("/getall")
	List<Position> getAll(){
		
		return this.positionsService.getAll();	
		
	}
	

}
