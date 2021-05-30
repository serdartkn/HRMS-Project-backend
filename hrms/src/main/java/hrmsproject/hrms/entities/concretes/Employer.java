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
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User{	
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "mail_is_verified", columnDefinition = "boolean default false")
	private Boolean mailIsVerified = false;
	
	@Column(name = "mng_is_verified", columnDefinition = "boolean default false")
	private Boolean MngIsVerified = false;
	
	

}
