package hrmsproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="job_seekers")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{
			
	@NonNull
	@Column(name="first_name")
	private String firstName;
	
	@NonNull
	@Column(name="last_name")
	private String lastName;
	
	@NonNull
	@Column(name="nationality_id")
	private String nationalityId;
	
	@NonNull
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;	

	@Column(name="mail_is_verified", columnDefinition = "boolean default false")
	private Boolean mailIsVerified = false;
	
}