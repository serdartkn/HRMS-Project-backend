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
@PrimaryKeyJoinColumn(name="id")
public class Employer extends User{	
	
	@NonNull
	@Column(name = "company_name")
	private String companyName;
	
	@NonNull
	@Column(name = "web_site")
	private String webSite;
	
	@NonNull
	@Column(name = "phone")
	private String phone;
	
	@NonNull
	@Column(name = "mail_is_verified", columnDefinition = "boolean default false")
	private Boolean mailIsVerified = false;
	
	@NonNull
	@Column(name = "mng_is_verified", columnDefinition = "boolean default false")
	private Boolean MngIsVerified = false;
	
	

}
