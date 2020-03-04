package com.proyecto.schoolroom.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	@Column
	private int turno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgrado")
		private Grado grado;
	
	//Constructores
	
	public Seccion() {}

	public Seccion(int id, String nombre, int turno, Grado grado) {
		this.id = id;
		this.nombre = nombre;
		this.turno = turno;
		this.grado = grado;
	}
	
	public Seccion(String nombre, int turno, Grado grado) {
		this.nombre = nombre;
		this.turno = turno;
		this.grado = grado;
	}
	
	//Getters && Setters

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

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}	
	
}
