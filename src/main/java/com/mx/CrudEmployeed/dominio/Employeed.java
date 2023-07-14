package com.mx.CrudEmployeed.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Estereotipos o anotaciones--- Indicar que esta clase pertenece a una tabla
@Entity
@Table(name = "EMPLOYEES")
public class Employeed {
	
	/*
	ID NUMBER PRIMARY KEY NOT NULL,
	ID_GENDERS NUMBER NOT NULL,
	ID_JOBS NUMBER NOT NULL,  
	NOMBRE NVARCHAR2(50) NOT NULL,
	LAST_NAME NVARCHAR2(50) NOT NULL,
	BRITHDATE DATE NOT NULL,
	FOREIGN KEY(ID_GENDERS) REFERENCES GENDERS (ID),
	FOREIGN KEY(ID_JOBS) REFERENCES JOBS (ID)
	 */
	
	// MAPEAR LA TABLA --- Variables o atributos de mi objeto
	@Id
	int id;
	String nombre;
	String last_name;
	LocalDate brithdate;

	//Cardinalidad
	@ManyToMany(mappedBy = "employed", cascade = CascadeType.ALL)
	List<Worked_Hours> listaWH = new ArrayList<Worked_Hours>();
	
	// fetch -- Indica que debe de ser cargada la entidad
	//FetchType.EAGER -- Indica que la cardinalidad es cargada al momento
		
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GENDERS")
	Genders gender;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_JOBS")
	Jobs job;
	
	public Employeed() {
	}

	public Employeed(int id) {
		this.id = id;
	}

	public Employeed(int id, String nombre, String last_name, LocalDate brithdate, Genders gender, Jobs job) {
		this.id = id;
		this.nombre = nombre;
		this.last_name = last_name;
		this.brithdate = brithdate;
		this.gender = gender;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employeed [id=" + id + ", nombre=" + nombre + ", last_name=" + last_name + ", brithdate=" + brithdate
				+ ", gender=" + gender + ", job=" + job + "]";
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getBrithdate() {
		return brithdate;
	}

	public void setBrithdate(LocalDate brithdate) {
		this.brithdate = brithdate;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}
	
	
}