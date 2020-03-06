package com.proyecto.schoolroom.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Grado{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private int num_grado;
	
	//Constructores
	
	public Grado() {}

	public Grado(int id, int num_grado) {
		this.id = id;
		this.num_grado = num_grado;
	}
	
	public Grado(int num_grado) {
		this.num_grado = num_grado;
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_grado() {
		return num_grado;
	}

	public void setNum_grado(int num_grado) {
		this.num_grado = num_grado;
	}
	
	
}
