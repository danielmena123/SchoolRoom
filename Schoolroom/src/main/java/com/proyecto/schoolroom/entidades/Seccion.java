package com.proyecto.schoolroom.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	@Column
	private int turno;
	
	//Constructores
	
	public Seccion() {}

	public Seccion(int id, String nombre, int turno) {
		this.id = id;
		this.nombre = nombre;
		this.turno = turno;
	}
	
	public Seccion(String nombre, int turno) {
		this.nombre = nombre;
		this.turno = turno;
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
}
