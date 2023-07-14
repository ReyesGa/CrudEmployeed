package com.mx.CrudEmployeed.server;

import java.util.List;
import com.mx.CrudEmployeed.dominio.Worked_Hours;


public interface ServerWorkedH {

	public void guardarWH(Worked_Hours wh);

	public void editarWH(Worked_Hours wh);

	public void eliminarWH(Worked_Hours wh);

	public Worked_Hours buscarWH(Worked_Hours wh);
	
	public List<Worked_Hours> mostrarWH();
}
