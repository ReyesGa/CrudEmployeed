/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
package com.mx.CrudEmployeed.controller;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.CrudEmployeed.dominio.Employeed;
import com.mx.CrudEmployeed.dominio.Genders;
import com.mx.CrudEmployeed.dominio.Jobs;
import com.mx.CrudEmployeed.dominio.Worked_Hours;
import com.mx.CrudEmployeed.server.ImplementServerEmployeed;
import com.mx.CrudEmployeed.server.ImplementServerGender;
import com.mx.CrudEmployeed.server.ImplementServerJob;
import com.mx.CrudEmployeed.server.ImplementServerWorkedH;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Estereotipos o anotaciones
@RestController
@RequestMapping("Employeed_WS")
@CrossOrigin
public class Employeed_WS {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ZONA DE INYECCIÓN DE DEPENDENCIAS

	// Inyeccion de dependencias
	@Autowired
	ImplementServerEmployeed impE;
	// Inyeccion de dependencias
	@Autowired
	ImplementServerJob impJ;
	// Inyeccion de dependencias
	@Autowired
	ImplementServerGender impG;
	// Inyeccion de dependencias
	@Autowired
	ImplementServerWorkedH impW;
	

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// OPERACIONES CRUD
	// EMPLOYEED

	// Listar Employeed
	// http://localhost:9000/Employeed_WS/mostrarEmployeed
	@GetMapping("mostrarEmployeed")
	public List<Employeed> mostrarEmployeed() {
		List<Employeed> EnployeedRes = impE.mostrarEmployed();
		return EnployeedRes;
	}
	
	// Guardar 
	// http://localhost:9000/Employeed_WS/saveEmployeed
	@PostMapping("saveEmployeed")
	public ResponseEntity<String> saveEmployeed(@RequestBody Employeed employeed) {
		impE.guardarEmployed(employeed);
		return new ResponseEntity<String>("|| Se ha guardado el genenro de forma exitosa", HttpStatus.OK);
	}

	// Guardar Employeed
	// http://localhost:9000/Employeed_WS/guardarEmployeed
	@PostMapping("guardarEmployeed")
	public ResponseEntity<String> guardarEmployeed(@RequestBody Employeed employeed) {

		// Validar si el empleado es mayor de edad
		LocalDate currentDate = LocalDate.now();
		LocalDate birthdate = employeed.getBrithdate();
		int edad = Period.between(birthdate, currentDate).getYears();
		if (edad < 18) {
			return ResponseEntity.badRequest().body("|| El empleado debe ser mayor de edad.");
		}

		// Validar si el nombre y apellido del empleado ya existen en la base de datos
		List<Employeed> existingEmployeeds = impE.mostrarEmployed();
		for (Employeed emp : existingEmployeeds) {
			if (emp.getNombre().equalsIgnoreCase(employeed.getNombre())
					&& emp.getLast_name().equalsIgnoreCase(employeed.getLast_name())) {
				return ResponseEntity.badRequest().body("|| El nombre y apellido ya están registrados.");
			}
		}

		// Validar que el genero y trabajo asignado sera existente para el empleado
		try {
			impE.guardarEmployed(employeed);
			if (employeed.getGender() != null) {
			}
			if(employeed.getJob() != null) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("|| Disculpe se ha generado un error: 400 al guardar el empleado.\n"
												  + "|| Se verifico en la base de datos y no existe el geneto o trabajo.\n"
												  + "|| Por favor ingrese el ID del genero o trabajo correctamente para guardar el empleado.\n"
												  + "|| Para el genero existen las ID: 100 y 200.\n"
												  + "|| Para el trabajo existen las ID: 560, 570, 580, 590.\n");
		}


		// Guardar el empleado en la base de datos
		impE.guardarEmployed(employeed);
		return new ResponseEntity<String>("|| Empleado cumple con todo los requerimientos necesarios. \n "
				                        + "|| Se ha registrado y guardado exitosamente al campo laboral.\n" +
				                          "**************************BIENVENIDO**************************",HttpStatus.OK);
	}

	// Editar employeed
	// http://localhost:9000/Employeed_WS/buscarEmployeed

	// Buscar Employeed
	// http://localhost:9000/Employeed_WS/buscarEmployeed
	@PostMapping("buscarEmployeed")
	public Employeed buscarEmployeed(@RequestBody Employeed employeed) {
		employeed = impE.buscarEmployed(employeed);
		return employeed;
	}

	// Eliminar Employeed
	// http://localhost:9000/Employeed_WS/eliminarEmployeed
	@PostMapping("eliminarEmployeed")
	public ResponseEntity<String> eliminarEmployeed(@RequestBody Employeed employeed) {
		impE.eliminarEmployed(employeed);
		return new ResponseEntity<String>("|| Se elimino el empleado de forma exitosa.", HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// OPERACIONES CRUD
	// GENDER

	// Listar Genders
	// http://localhost:9000/Employeed_WS/mostrarGender
	@GetMapping("mostrarGender")
	public List<Genders> mostrarGender() {
		List<Genders> gendersList = impG.mostrarGender();
		return gendersList;
	}

	// Guardar Genders
	// http://localhost:9000/Employeed_WS/mostrarGender
	@PostMapping("guardarGender")
	public ResponseEntity<String> guardarGender(@RequestBody Genders gender) {
		impG.guardarGender(gender);
		return new ResponseEntity<String>("|| Se ha guardado el genenro de forma exitosa", HttpStatus.OK);
	}

	// Buscar Genders
	// http://localhost:9000/Employeed_WS/mostrarGender
	@PostMapping("buscarGender")
	public Genders buscarGender(@RequestBody Genders gender) {
		gender = impG.buscarGender(gender);
		return gender;
	}

	// Guardar Genders
	// http://localhost:9000/Employeed_WS/editarGender
	@PostMapping("editarGender")
	public ResponseEntity<String> editarGender(@RequestBody Genders gender) {
		impG.guardarGender(gender);
		return new ResponseEntity<String>("|| Se ha editado el genenro de forma exitosa", HttpStatus.OK);
	}

	// Eliminar Genders
	// http://localhost:9000/Employeed_WS/eliminarGender
	@PostMapping("eliminarGender")
	public ResponseEntity<String> eliminarGender(@RequestBody Genders gender) {
		impG.guardarGender(gender);
		return new ResponseEntity<String>("|| Se ha editado el genenro de forma exitosa", HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// OPERACIONES CRUD
	// JOBS

	// Listar Jobs
	// http://localhost:9000/Employeed_WS/mostrarJob
	@GetMapping("mostrarJob")
	public List<Jobs> mostrarJob() {
		List<Jobs> jobsList = impJ.mostrarJobs();
		return jobsList;
	}

	// Guardar Job
	// http://localhost:9000/Employeed_WS/mostrarJob
	@PostMapping("guardarJob")
	public ResponseEntity<String> guardarJob(@RequestBody Jobs job) {
		impJ.guardarJobs(job);
		return new ResponseEntity<String>("|| Se ha guardado el trabajo de forma correcta", HttpStatus.OK);
	}

	// Buscar Job
	// http://localhost:9000/Employeed_WS/buscarJob
	@PostMapping("buscarJob")
	public Jobs buscarJob(@RequestBody Jobs job) {
		job = impJ.buscarJobs(job);
		return job;
	}

	// Editar Job
	// http://localhost:9000/Employeed_WS/editarJob
	@PostMapping("editarJob")
	public ResponseEntity<String> editarJob(@RequestBody Jobs job) {
		impJ.editarJobs(job);
		return new ResponseEntity<String>("|| Se ha cambiado el trabajo de forma correcta", HttpStatus.OK);
	}

	// Editar Job
	// http://localhost:9000/Employeed_WS/eliminarJob
	@PostMapping("eliminarJob")
	public ResponseEntity<String> eliminarJob(@RequestBody Jobs job) {
		impJ.eliminarJobs(job);
		return new ResponseEntity<String>("|| Se ha eliminado el trabajo de forma exitosa", HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// OPERACIONES CRUD
	// WORKED HOURS

	// Listar Worked Hours
	// http://localhost:9000/Employeed_WS/mostrarWorkedH
	@GetMapping("mostrarWorkedH")
	public List<Worked_Hours> mostrarWorkedH() {
		List<Worked_Hours> listWH = impW.mostrarWH();
		return listWH;
	}

	// Guardar Worked Hours
	// http://localhost:9000/Employeed_WS/guardarWorkedH
	@PostMapping("guardarWorkedH")
	public ResponseEntity<String> guardarWorkedH(@RequestBody Worked_Hours wh) {
		
		try {
			impW.guardarWH(wh);
			if(wh.getEmployed()!=null);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("|| Las horas asiganadas deben de ser a un trabajador real");
		}
		impW.guardarWH(wh);
		return new ResponseEntity<String>("|| Se ha guardado las horas de trabajo de forma exitosa", HttpStatus.OK);
	}

	// Buscar Worked Hours
	// http://localhost:9000/Employeed_WS/buscarWorkedH
	@PostMapping("buscarWorkedH")
	public Worked_Hours buscarWorkedH(@RequestBody Worked_Hours wh) {
		wh = impW.buscarWH(wh);
		return wh;
	}

	// Editar Worked Hours
	// http://localhost:9000/Employeed_WS/editarWorkedH
	@PostMapping("editarWorkedH")
	public ResponseEntity<String> editarWorkedH(@RequestBody Worked_Hours wh) {
		impW.editarWH(wh);
		return new ResponseEntity<String>("|| Se han modificado las horas de trabajo de forma exitosa", HttpStatus.OK);
	}

	// Eliminar Worked Hours
	// http://localhost:9000/Employeed_WS/guardarWorkedH
	@PostMapping("eliminarWorkedH")
	public ResponseEntity<String> eliminarWorkedH(@RequestBody Worked_Hours wh) {
		impW.eliminarWH(wh);
		return new ResponseEntity<String>("|| Se ha eliminado las horas de trabajo de forma exitosa", HttpStatus.OK);
	}

}
