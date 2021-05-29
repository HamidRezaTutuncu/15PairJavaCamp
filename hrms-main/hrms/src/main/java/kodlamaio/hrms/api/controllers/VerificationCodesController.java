package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.Result;

@RestController


@RequestMapping("/api/userverify")
public class VerificationCodesController {
	
	
	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	@GetMapping("/activate/{code}") // @PathVariable : değeri path'den almak için
	public Result activateUser(@PathVariable String code) {
		return verificationCodeService.activateUser(code);
		
	}
	
	

}
