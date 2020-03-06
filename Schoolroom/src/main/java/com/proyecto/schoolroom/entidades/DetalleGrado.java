package com.proyecto.schoolroom.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table
@Entity
public class DetalleGrado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgrado")
		private Grado grado;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idseccion")
		private Seccion seccion;
	
	//Constructores
	
	public DetalleGrado() {}
	
	public DetalleGrado(int id, Grado grado, Seccion seccion) {
		this.id = id;
		this.grado = grado;
		this.seccion = seccion;
	}

	public DetalleGrado(Grado grado, Seccion seccion) {
		this.grado = grado;
		this.seccion = seccion;
	}
	
	//Getters && Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
}
