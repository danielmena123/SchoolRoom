package com.proyecto.schoolroom.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Table
@Entity
public class Grado{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private int num_grado;
	@Column
	private String seccion;
	@Column
	private String codigo;
	
	@OneToMany(mappedBy = "grado")
	@JsonManagedReference("grado")
	private List<Materia> listamateria;
	
	//Constructores
	
	public Grado() {}

	public Grado(int id, int num_grado, String seccion, String codigo) {
		this.id = id;
		this.num_grado = num_grado;
		this.seccion = seccion;
		this.codigo = codigo;
	}
	
	public Grado(int num_grado, String seccion, String codigo) {
		this.num_grado = num_grado;
		this.seccion = seccion;
		this.codigo = codigo;
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

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
