package com.proyecto.schoolroom.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String correo_electronico;
	
	//Constructores
	
	public Docente() {}

	public Docente(int id, String nombres, String apellidos, String correo_electronico) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
	}
	
	public Docente(String nombres, String apellidos, String correo_electronico) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	
}
