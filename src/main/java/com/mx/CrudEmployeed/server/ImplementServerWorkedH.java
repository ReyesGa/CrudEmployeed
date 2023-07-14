package com.mx.CrudEmployeed.server;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.CrudEmployeed.dao.WorkedHDao;
import com.mx.CrudEmployeed.dominio.Worked_Hours;

@Service
public class ImplementServerWorkedH implements ServerWorkedH{

	// Inyección de dependencias
	@Autowired
	WorkedHDao workedHDao;
		
	@Override
	public void guardarWH(Worked_Hours wh) {
		// TODO Auto-generated method stub
		workedHDao.save(wh);
	}

	@Override
	public void editarWH(Worked_Hours wh) {
		// TODO Auto-generated method stub
		workedHDao.save(wh);
	}

	@Override
	public void eliminarWH(Worked_Hours wh) {
		// TODO Auto-generated method stub
		workedHDao.delete(wh);
	}

	@Override
	public Worked_Hours buscarWH(Worked_Hours wh) {
		// TODO Auto-generated method stub
		return workedHDao.findById(wh.getId()).orElse(null);
	}

	@Override
	public List<Worked_Hours> mostrarWH() {
		// TODO Auto-generated method stub
		return (List<Worked_Hours>) workedHDao.findAll();
	}

}
