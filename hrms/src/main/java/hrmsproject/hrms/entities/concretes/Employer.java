package hrmsproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer extends User{	
	
	@Column(name = "company_name")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Size(min = 2, message = "Company Name Must Be A Minimum Of 2 Characters")
	private String companyName;
	
	@Column(name = "web_site")
	@NotBlank(message = "This Field Cannot Be Empty.")
	@Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$")
	private String webSite;	

	@Column(name = "phone")
	@Size(min = 6, message = "Write The Phone Number With The Area Code.")
	@Pattern(regexp = "^[0-9]{1}[0-9]{10,11}$", message = "Başında + Olmadan Alan Koduyla Giriniz.")
	private String phone;
	
	@Column(name = "mail_is_verified")
	private Boolean mailIsVerified = false;
	
	@Column(name = "mng_is_verified")
	private Boolean mngIsVerified = false;
	
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;
	
}