package hrmsproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_position_id")
	private int jobPositionId;
	
//	@Column(name = "employer_id")
//	private int employerId;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@Column(name = "desciription")
	private String desciription;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "quota")
	private int quato;
	
	@Column(name = "app_deadline")
	private LocalDate appDeadline;
	
	@Column(name = "is_active")
	private Boolean isActive = true;
	
	@Column(name = "release_date")
	private LocalDate releaseDate = LocalDate.now();

}