package kodlamaio.hrms.core.adapters;


import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisDemoService;

@Service
public class MernisDemo implements MernisDemoService {

	
	 public boolean isValidNationalityIdentity(String tcNO) {
			
			String regex  = "^[0-9]+$";
			
			if(tcNO.length() != 11) {
				return false;
			}
			
			Pattern pattern = java.util.regex.Pattern.compile(regex);
			return pattern.matcher(tcNO).find();
	
	
	}
}
	
	


