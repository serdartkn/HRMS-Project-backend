package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.JobSeekerService;
import hrmsproject.hrms.business.abstracts.PersonCheckService;
import hrmsproject.hrms.core.mailCheck.MailCheckManager;
import hrmsproject.hrms.core.mailCheck.MailValidationManager;
import hrmsproject.hrms.core.utilities.result.concretes.DataResult;
import hrmsproject.hrms.core.utilities.result.concretes.ErrorResult;
import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsproject.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService{
	
	JobSeekerDao jobSeekerDao;
	PersonCheckService personCheckService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, PersonCheckService personCheckService) {
		this.jobSeekerDao = jobSeekerDao;
		this.personCheckService = personCheckService;
	}
	

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(MailCheckManager.checkMail(jobSeeker.getEmail())) 
		{
			if(jobSeekerDao.existsByEmail(jobSeeker.getEmail())!=true 
					&& jobSeekerDao.existsByNationalityId(jobSeeker.getNationalityId())!=true) 
			{				
				if (personCheckService.ifCheckRealPerson(jobSeeker) && jobSeeker.getPassword().length()>=6 )
					
				{
					MailValidationManager.sendMail(jobSeeker.getEmail());									
					this.jobSeekerDao.save(jobSeeker);
					return new SuccessResult("İş Arayan Eklendi");
				}
				else					
				{
					if (personCheckService.ifCheckRealPerson(jobSeeker)==false) 
					{
						return new ErrorResult("Hatalı Kimlik Bilgisi, Lütfen Bilgilerinizi Kontrol Edin.");
					}
//					else if (jobSeeker.getPassword().length()<6 && jobSeeker.getPasswordVerification().length()<6) 
//					{
//						return new ErrorResult("Parola Minimum 6 Karakterden Oluşturmalıdır.");
//					}
//					else if (jobSeeker.getPassword()!=jobSeeker.getPasswordVerification()) 
//					{
//						return new ErrorResult("Şifreler Eşleşmiyor, Lütfen Tekrar Girin.");
//					}
				}						
			}
			else
			{
				return new ErrorResult("Bu E-mail Sisteme Kayıtlıdır. Lütfen Giriş Yapın.");
			}			
		}
		
		return new ErrorResult("Hatalı E-mail!");		
	}


	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean existsByEmail(String eMail) {
		
		if (this.jobSeekerDao.existsByEmail(eMail)) {
			
			return true;
			
		}
		return false;
		
		
		
	}


	@Override
	public Boolean existsByNationalityId(String nationalityId) {
		if (this.jobSeekerDao.existsByNationalityId(nationalityId)) {
			
			return true;
			
		}
		return false;
		
	}
	
	
}

