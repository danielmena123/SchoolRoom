package com.proyecto.schoolroom.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table
@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idgrado")
	@JsonBackReference("grado")
		private Grado grado;
	
	
	@OneToMany(mappedBy = "materia")
	@JsonManagedReference("materia")
	private List<Tarea> listatarea;
	//Constructores
	
	public Materia() {};

	public Materia(int id, String nombre, Grado grado) {
		this.id = id;
		this.nombre = nombre;
		this.grado = grado;
	}
	
	public Materia(String nombre, Grado grado) {
		this.nombre = nombre;
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

	public Grado getSeccion() {
		return grado;
	}

	public void setSeccion(Grado grado) {
		this.grado = grado;
	}
	
}
