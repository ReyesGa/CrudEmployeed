package com.mx.CrudEmployeed.server;

import java.util.List;
import com.mx.CrudEmployeed.dominio.Employeed;

public interface ServerEnployeed {

	public void guardarEmployed(Employeed employe);

	public void editarEmployed(Employeed employe);

	public void eliminarEmployed(Employeed employe);

	public Employeed buscarEmployed(Employeed employe);
	
	public List<Employeed> mostrarEmployed();
}
