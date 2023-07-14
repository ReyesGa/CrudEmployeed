package com.mx.CrudEmployeed.dominio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Estereotipos o anotaciones--- Indicar que esta clase pertenece a una tabla
@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class Worked_Hours {
	
	/*
	ID NUMBER PRIMARY KEY NOT NULL,
	ID_EMPLOYEED NUMBER NOT NULL,
	WORKED_HOURS NUMBER NOT NULL,
	WORKED_DATE DATE NOT NULL,
	FOREIGN KEY(ID_EMPLOYEED) REFERENCES EMPLOYEES (ID)
	 */
	
	@Id
	int id;
	int worked_Hours;
	LocalDate worked_date;
	
	// fetch -- Indica que debe de ser cargada la entidad
	//FetchType.EAGER -- Indica que la cardinalidad es cargada al momento
			
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPLOYEED")
	Employeed employed;

	public Worked_Hours() {
	}

	public Worked_Hours(int id) {
		this.id = id;
	}

	public Worked_Hours(int id, int worked_Hours, LocalDate worked_date, Employeed employed) {
		this.id = id;
		this.worked_Hours = worked_Hours;
		this.worked_date = worked_date;
		this.employed = employed;
	}

	@Override
	public String toString() {
		return "Worked_Hours [id=" + id + ", worked_Hours=" + worked_Hours + ", worked_date=" + worked_date
				+ ", employed=" + employed + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorked_Hours() {
		return worked_Hours;
	}

	public void setWorked_Hours(int worked_Hours) {
		this.worked_Hours = worked_Hours;
	}

	public LocalDate getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(LocalDate worked_date) {
		this.worked_date = worked_date;
	}

	public Employeed getEmployed() {
		return employed;
	}

	public void setEmployed(Employeed employed) {
		this.employed = employed;
	}
	
	
	
}
