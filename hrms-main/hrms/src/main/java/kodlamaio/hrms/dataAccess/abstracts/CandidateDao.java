package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
	
	List<Candidate> findAllByEmail(String email);
	
	//Candidate findByIdentificationNumber(String identificationNumber);
	

}
