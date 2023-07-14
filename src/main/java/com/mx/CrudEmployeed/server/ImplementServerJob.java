package com.mx.CrudEmployeed.server;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.CrudEmployeed.dao.JobDao;
import com.mx.CrudEmployeed.dominio.Jobs;

@Service
public class ImplementServerJob implements ServerJob{

	// Inyección de dependencias
	@Autowired
	JobDao jobDao;
	
	@Override
	public void guardarJobs(Jobs job) {
		// TODO Auto-generated method stub
		jobDao.save(job);
	}

	@Override
	public void editarJobs(Jobs job) {
		// TODO Auto-generated method stub
		jobDao.save(job);
	}

	@Override
	public void eliminarJobs(Jobs job) {
		// TODO Auto-generated method stub
		jobDao.delete(job);
	}

	@Override
	public Jobs buscarJobs(Jobs job) {
		// TODO Auto-generated method stub
		return jobDao.findById(job.getId()).orElse(null);
	}

	@Override
	public List<Jobs> mostrarJobs() {
		// TODO Auto-generated method stub
		return (List<Jobs>) jobDao.findAll();
	}

}
