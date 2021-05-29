package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
@Service
public class JobPositionManager implements JobPositionService {
	
	
	private JobPositionDao jobPositonDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositonDao) {
		super();
		this.jobPositonDao = jobPositonDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositonDao.findAll(),("İş pozisyonları listelendi"));
		
	}

	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositonDao.save(jobPosition);
		return new SuccessResult("Yeni iş poziyonu eklendi");
		
	}

	@Override
	public DataResult<List<JobPosition>> findAllByPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

}
