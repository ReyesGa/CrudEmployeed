package com.mx.CrudEmployeed.server;

import java.util.List;
import com.mx.CrudEmployeed.dominio.Genders;


public interface ServerGender {

	public void guardarGender(Genders gender);

	public void editarGender(Genders gender);

	public void eliminarGender(Genders gender);

	public Genders buscarGender(Genders gender);
	
	public List<Genders> mostrarGender();
}
