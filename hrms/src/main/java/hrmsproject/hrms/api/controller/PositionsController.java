package hrmsproject.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.PositionService;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions/")
public class PositionsController{
	
	private PositionService positionService;	
	@Autowired
	public PositionsController(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Position>>getAll(){		
		return this.positionService.getAll();		
	}

	@PostMapping("add")
	public Result add(@RequestBody Position position) {		
		return this.positionService.add(position);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody String name, @RequestBody int id) {		
		return this.positionService.updatePosition(name,id);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody Position position) {		
		return this.positionService.deletePosition(position);
	}
}