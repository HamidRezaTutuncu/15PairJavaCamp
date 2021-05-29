package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
@Service
public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> findAllByPosition(String position);

}
