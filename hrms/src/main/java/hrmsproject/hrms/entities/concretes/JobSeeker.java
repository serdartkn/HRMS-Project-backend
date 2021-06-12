package hrmsproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User{
			
	@Column(name="first_name")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Size(min = 2, message = "First Name Must Be A Minimum Of 2 Characters")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Size(min = 2, message = "Position Name Must Be A Minimum Of 2 Characters")
	private String lastName;	

	@Column(name="nationality_id")
	@NotNull(message = "This Field Cannot Be Empty.")
	@Size(min = 11, max = 11, message = "Nationality ID Number Must Be 11 Digits")
	private String nationalityId;	

	@Column(name="date_of_birth")
	@NotNull(message = "This Field Cannot Be Empty.")
	@Past()
	private LocalDate dateOfBirth;	

	@Column(name="mail_is_verified")
	private Boolean mailIsVerified = false;	
	
}