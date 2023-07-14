package com.mx.CrudEmployeed.server;

import java.util.List;
import com.mx.CrudEmployeed.dominio.Jobs;


public interface ServerJob {

	public void guardarJobs(Jobs job);

	public void editarJobs(Jobs job);

	public void eliminarJobs(Jobs job);

	public Jobs buscarJobs(Jobs job);
	
	public List<Jobs> mostrarJobs();
}
