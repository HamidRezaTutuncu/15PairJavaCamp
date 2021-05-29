package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.MernisDemoService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private MernisDemoService mernisDemoService;
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao, VerificationCodeService verificationCodeService,
			MernisDemoService mernisDemoService) {
		super();
		this.candidateDao = candidateDao;
		
		this.verificationCodeService = verificationCodeService;
		this.mernisDemoService = mernisDemoService;	}

		
	

	@Override
	
	public Result add(Candidate candidate) {
		if(candidate.getFirstname()==null) {
			return new ErrorResult("İsim Bölümü Boş Bırakılamaz");
		}
		else if (candidate.getLastname()==null) {
			return new ErrorResult("Soyisim Bölümü Boş Bırakılamaz");
		}
		else if(candidate.getBirthDate()==null) {
			return new ErrorResult("Doğum Tarihi Bölümü Boş Bırakılamaz");
		}
		else if(candidate.getEmail()==null) {
			return new ErrorResult("E-posta Bölümü Boş Bırakılamaz");
		}
		else if(candidate.getPassword().length()<=6) {
			return new ErrorResult("Parola Bölümü 6 Karakterden Az Oluşamaz");//Boşluk için önlem alınacak
		}
		else if (!mernisDemoService.isValidNationalityIdentity(candidate.getIdentificationNumber() )) {
			return new ErrorResult("Kimlik No Doğrulaması Yapılamadı");
		}
		else if (isEmailValid(candidate.getEmail())) {
			
			
			Candidate  savedUser = this.candidateDao.save(candidate);
			String returnedCode = this.verificationCodeService.createActivationCode(savedUser);
			//User  savedUser = this.userDao.save(candidate);
        	//this.candidateDao.save(candidate);
			return new SuccessResult(candidate.getEmail() + " Adresine doğrulama kodu gönderildi");
		}
		else {
//			Candidate verifyCandidate = new Candidate();
//			verifyCandidate.setMailVerify(false);
			
			return new ErrorResult("Kullanıcı Bilgileri Geçersizdir");
			
		}
		
	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	@Override
	public DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAllByIdentificationNumber(identificationNumber),"Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> findAllByEmail(String email) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAllByEmail(email),"Listelendi");
		
	}
	@Override
	public DataResult<List<Candidate>> findAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), ("İş arayanlar listelendi"));
	
	}
}
