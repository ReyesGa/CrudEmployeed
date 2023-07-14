package com.mx.CrudEmployeed.server;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.CrudEmployeed.dao.EmployeedDao;
import com.mx.CrudEmployeed.dominio.Employeed;

@Service
public class ImplementServerEmployeed implements ServerEnployeed{

	// Inyección de dependencias
	@Autowired
	EmployeedDao employedDao;
	
	@Override
	public void guardarEmployed(Employeed employe) {
		// TODO Auto-generated method stub
		employedDao.save(employe);
		
	}

	@Override
	public void editarEmployed(Employeed employe) {
		// TODO Auto-generated method stub
		employedDao.save(employe);
	}

	@Override
	public void eliminarEmployed(Employeed employe) {
		// TODO Auto-generated method stub
		employedDao.delete(employe);
	}

	@Override
	public Employeed buscarEmployed(Employeed employe) {
		// TODO Auto-generated method stub
		return employedDao.findById(employe.getId()).orElse(null);
	}

	@Override
	public List<Employeed> mostrarEmployed() {
		// TODO Auto-generated method stub
		return (List<Employeed>) employedDao.findAll();
	}

}
