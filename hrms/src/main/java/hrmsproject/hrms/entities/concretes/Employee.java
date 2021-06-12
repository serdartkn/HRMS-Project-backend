package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User{
	
	@Column(name="first_name")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Size(min = 2, message = "First Name Must Be A Minimum Of 2 Characters")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Size(min = 2, message = "Position Name Must Be A Minimum Of 2 Characters")
	private String lastName;	
	
}