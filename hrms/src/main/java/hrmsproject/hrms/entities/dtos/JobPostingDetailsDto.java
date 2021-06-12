package hrmsproject.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDetailsDto {
	
//	private Boolean isActive;
	private String companyName;	
	private String positionName;
//	private int minSalary;
//	private int maxSalary;
	private int quato;
	private String cityName;
	private LocalDate releaseDate;
	private LocalDate appDeadline;
	
}