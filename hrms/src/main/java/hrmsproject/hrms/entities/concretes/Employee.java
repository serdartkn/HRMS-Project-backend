package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Entity
@Data
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Employee extends User{
	
	@NonNull
	@Column(name="first_name")
	private String firstName;
	
	@NonNull
	@Column(name="last_name")
	private String lastName;
}