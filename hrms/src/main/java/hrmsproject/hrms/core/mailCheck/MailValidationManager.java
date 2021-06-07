package hrmsproject.hrms.core.mailCheck;

import hrmsproject.hrms.core.utilities.result.concretes.Result;
import hrmsproject.hrms.core.utilities.result.concretes.SuccessResult;

public class MailValidationManager {
	
	public static Result sendMail(String eMail) {		
		return new SuccessResult(eMail + " " + "Adresine Mail Doğrulama Linki Gönderilmiştir.");		
	}
}