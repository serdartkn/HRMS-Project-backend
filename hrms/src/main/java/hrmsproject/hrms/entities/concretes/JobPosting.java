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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

//	@Column(name = "job_position_id")
//	private int jobPositionId;
	
	@ManyToOne()
	@JoinColumn(name = "jobPosition_id")
	private JobPosition jobPosition;
	
//	@Column(name = "employer_id")
//	private int employerId;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Column(name = "desciription")
	@NotBlank(message = "This Field Cannot Be Empty.")
	private String desciription;
	
//	@Column(name = "city_id")
//	private int cityId;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
		
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "quota")
	@NotNull(message = "This Field Cannot Be Empty.")
	@Positive(message = "Enter A Number Greater Than 0.")
	private int quato;
	
	@Column(name = "app_deadline")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Future(message = "Enter A Date After Today.")
	private LocalDate appDeadline;
	
	@Column(name = "is_active")
	private Boolean isActive = true;
	
	@Column(name = "release_date")
	private LocalDate releaseDate = LocalDate.now();
	
}