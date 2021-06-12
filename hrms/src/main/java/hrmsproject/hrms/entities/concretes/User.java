package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	

	@Column(name="email")
	@NotBlank (message = "Please Enter Your E-Mail Address")
	@Email(message = "Please Enter An E-Mail Address In The Correct Format.")
	private String email;	
	
	@Column(name ="password")
	@NotBlank(message = "Password Must Be A Minimum Of 6 Characters")
	@Size(min = 6, message = "Password Must Be A Minimum Of 6 Characters")
	private String password;
	
}