package com.mx.CrudEmployeed.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Estereotipos o anotaciones--- Indicar que esta clase pertenece a una tabla
@Entity
@Table(name = "JOBS")
public class Jobs {
	/*
	 *ID NUMBER PRIMARY KEY NOT NULL,
	NOMBRE NVARCHAR2(50) NOT NULL,
	SALARY NUMBER NOT NULL  --- Salary by month
	 */
	
	// MAPEAR LA TABLA --- Variables o atributos de mi objeto
	@Id
	int id;
	String nombre;
	Double salary;
	
	// Cadibalidad
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	List<Employeed> listaEm = new ArrayList<Employeed>();

	public Jobs() {
	}

	public Jobs(int id) {
		this.id = id;
	}

	public Jobs(int id, String nombre, Double salary) {
		this.id = id;
		this.nombre = nombre;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", nombre=" + nombre + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}