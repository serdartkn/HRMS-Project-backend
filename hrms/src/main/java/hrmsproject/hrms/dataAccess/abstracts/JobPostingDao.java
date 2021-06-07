package hrmsproject.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrmsproject.hrms.entities.concretes.JobPosting;
import hrmsproject.hrms.entities.dtos.JobPostingDetailsDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{	
	
	//Son Başvuru Tarihi Geçmemiş ve Durumu Aktif Olan Tüm İş İlanlarını DTO Formatında Getirir.
	@Query("Select new hrmsproject.hrms.entities.dtos.JobPostingDetailsDto"
			+ "(j.isActive, e.companyName, p.name, j.minSalary, j.maxSalary, j.quato, c.name, j.releaseDate, j.appDeadline) "
			+ "From Employer e "
			+ "Inner Join e.jobPostings j "
			+ "Inner Join j.city c "
			+ "Inner Join j.position p "
			+ "where j.isActive='true' "
			+ "AND j.appDeadline>=NOW()")
	List<JobPostingDetailsDto> findByAppDeadlineAfterAndIsActive();
	
	//Son Başvuru Tarihi Geçmemiş ve Durumu Aktif Olan Tüm İş İlanlarını İlanın Sisteme Eklenme Tarihine Göre DTO Formatında Getirir.
	@Query("Select new hrmsproject.hrms.entities.dtos.JobPostingDetailsDto"
			+ "(j.isActive, e.companyName, p.name, j.minSalary, j.maxSalary, j.quato, c.name, j.releaseDate, j.appDeadline) "
			+ "From Employer e "
			+ "Inner Join e.jobPostings j "
			+ "Inner Join j.city c "
			+ "Inner Join j.position p "
			+ "WHERE j.isActive='true' "
			+ "AND j.appDeadline>=NOW() "
			+ "ORDER BY j.releaseDate")
	List<JobPostingDetailsDto> sortedAllJobPostingWithAppDeadLineIsActive();	
	
	//Id'si Verilen Şirketin Son Başvuru Tarihi Geçmemiş ve Durumu Aktif Olan Tüm İş İlanlarını DTO formatında Getirir.
	@Query("Select new hrmsproject.hrms.entities.dtos.JobPostingDetailsDto"
			+ "(j.isActive, e.companyName, p.name, j.minSalary, j.maxSalary, j.quato, c.name, j.releaseDate, j.appDeadline) "
			+ "From Employer e "
			+ "Inner Join e.jobPostings j "
			+ "Inner Join j.city c "
			+ "Inner Join j.position p "
			+ "WHERE j.isActive='true' "
			+ "AND j.appDeadline>=NOW() "
			+ "AND e.id=:id ")
	List<JobPostingDetailsDto> findAllJobPostingByEmployerId(int id);	
	
	@Modifying
    @Transactional
    @Query("update JobPosting j set j.jobPositionId=:jobPositionId, j.desciription=:desciription, j.cityId=:cityId, j.minSalary=:minSalary, j.maxSalary=:maxSalary, j.quato=:quato, j.appDeadline=:appDeadline where j.id=:id")
    void updateJobPosting(int jobPositionId, String desciription, int cityId, int minSalary, int maxSalary, int quato, LocalDate appDeadline, int id);
		
	@Modifying
    @Transactional
    @Query("update JobPosting j set j.isActive=:active where j.id=:id")
    void updateIsActive(boolean active, int id);
	
}