package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
    DataResult<List<VerificationCode>> findAllByCode();
    VerificationCode findByCode(String code);
	String createActivationCode(User user);
	Result activateUser(String activationCode);
	

	
	
	

}
