package hrmsproject.hrms.adapter;

import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.PersonCheckService;
import hrmsproject.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements PersonCheckService{

	@Override
	public boolean ifCheckRealPerson(JobSeeker jobSeeker) {		
			KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
			boolean result = false;
			
			try 
			{
				result = proxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()), jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(), jobSeeker.getDateOfBirth().getYear());		
			} 
			catch (Exception e) 
			{
				System.out.println("Not a valid person");
			}
			
			return result;
	}
}