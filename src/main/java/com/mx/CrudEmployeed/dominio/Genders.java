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
@Table(name = "GENDERS")
public class Genders {
	
	/*
	 ID NUMBER PRIMARY KEY NOT NULL,
	NOMBRE NVARCHAR2(50) NOT NULL
	 */
	
	// MAPEAR LA TABLA --- Variables o atributos de mi objeto
	@Id
	int id;
	String nombre;
	
	// Cadibalidad
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	List<Employeed> listaEm = new ArrayList<Employeed>();

	public Genders() {
	}

	public Genders(int id) {
		this.id = id;
	}

	public Genders(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Genders [id=" + id + ", nombre=" + nombre + "]";
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
	
	

	
}