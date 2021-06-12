package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	@Modifying
    @Transactional
    @Query("update Employer e set e.email=:email, e.webSite=:webSite where e.id=:id")
    void updateCompanyWebSiteAndEmail(String email, String webSite, int id);
	
	@Modifying
    @Transactional
    @Query("update Employer e set e.companyName=:companyName, e.phone=:phone where e.id=:id")
    void updateCompanyNameAndPhone(String companyName, String phone, int id);
	
	@Modifying
    @Transactional
    @Query("update Employer e "
    		+ "set e.mailIsVerified=:mailIsVerified "
    		+ "where e.id=:id")
    void updateMailIsVerified(boolean mailIsVerified, int id);	
	
	@Modifying
    @Transactional
    @Query("update Employer e "
    		+ "set e.mngIsVerified=:mngIsVerified "
    		+ "where e.id=:id")
    void updateMngIsVerified(boolean mngIsVerified, int id);		
	
}