package com.mx.CrudEmployeed.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.CrudEmployeed.dao.GenderDao;
import com.mx.CrudEmployeed.dominio.Genders;

@Service
public class ImplementServerGender implements ServerGender{

	// Inyección de dependencias
	@Autowired
	GenderDao genderDao;
		
	@Override
	public void guardarGender(Genders gender) {
		// TODO Auto-generated method stub
		genderDao.save(gender);
	}

	@Override
	public void editarGender(Genders gender) {
		// TODO Auto-generated method stub
		genderDao.save(gender);
	}

	@Override
	public void eliminarGender(Genders gender) {
		// TODO Auto-generated method stub
		genderDao.delete(gender);
	}

	@Override
	public Genders buscarGender(Genders gender) {
		// TODO Auto-generated method stub
		return genderDao.findById(gender.getId()).orElse(null);
	}

	@Override
	public List<Genders> mostrarGender() {
		// TODO Auto-generated method stub
		return (List<Genders>) genderDao.findAll();
	}
	

}
