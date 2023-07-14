package com.mx.CrudEmployeed.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mx.CrudEmployeed.dominio.Employeed;
import com.mx.CrudEmployeed.server.ImplementServerEmployeed;
import com.mx.CrudEmployeed.server.ImplementServerGender;
import com.mx.CrudEmployeed.server.ImplementServerJob;
import com.mx.CrudEmployeed.server.ImplementServerWorkedH;

@Controller
@RequestMapping("api/EmployeedWS_Conrtrol")
public class EmployeedWS_Conrtrol {

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

	//indexEmployeed
	
	//listar
	// http://localhost:9000/api/EmployeedWS_Conrtrol/mostrarEmployeed
	@GetMapping("mostrarEmployeed")
	public String mostrarEmployeed(Model model){
		var listEmployeed = impE.mostrarEmployed();
		model.addAttribute("mostrarEmployeed",listEmployeed);
		return "indexEmployeed";
	}
	
	// Abrir modal de estados para dar de alta
		// http://localhost:9000/api/EstadosControl/openModal
		@GetMapping("openModal")
		public String openModal() {
			return "altaEmployeed";
		}
	
	// Guardar Employeed
	// http://localhost:9000/Employeed_WS/guardarEmployeed
	@PostMapping("guardarEmployeed")
	public String guardarEmployeed(@RequestBody Employeed employeed) {

		// Validar si el empleado es mayor de edad
		LocalDate currentDate = LocalDate.now();
		LocalDate birthdate = employeed.getBrithdate();
		int edad = Period.between(birthdate, currentDate).getYears();
		if (edad < 18) {
		}

		// Validar si el nombre y apellido del empleado ya existen en la base de datos
		List<Employeed> existingEmployeeds = impE.mostrarEmployed();
		for (Employeed emp : existingEmployeeds) {
			if (emp.getNombre().equalsIgnoreCase(employeed.getNombre())
					&& emp.getLast_name().equalsIgnoreCase(employeed.getLast_name())) {
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
			// TODO: handle exception}
		}

		// Guardar el empleado en la base de datos
		impE.guardarEmployed(employeed);
		return "redirect:mostrarEmployeed";
	}

}
