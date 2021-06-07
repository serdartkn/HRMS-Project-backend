package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User{
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
}