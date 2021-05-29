package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public interface CandidateService {
	
	DataResult<List<Candidate>> findAll();
	
	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber);
	
	//DataResult<User> findByEmail(String email);
	
	//DataResult<Candidate> findByIdentificationNumber(String identificationNumber);
	
	DataResult<List<Candidate>> findAllByEmail(String email);
}
