package com.proyecto.schoolroom.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private Date fecha_asignada;
	@Column
	private Date fecha_entrega;
	@Column
	private String descripcion;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idmateria")
		private Materia materia;
	
	//Constructores
	
	public Tarea() {}

	public Tarea(int id, Date fecha_asignada, Date fecha_entrega, String descripcion, Materia materia) {
		this.id = id;
		this.fecha_asignada = fecha_asignada;
		this.fecha_entrega = fecha_entrega;
		this.descripcion = descripcion;
		this.materia = materia;
	}
	
	public Tarea(Date fecha_asignada, Date fecha_entrega, String descripcion, Materia materia) {
		this.fecha_asignada = fecha_asignada;
		this.fecha_entrega = fecha_entrega;
		this.descripcion = descripcion;
		this.materia = materia;
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_asignada() {
		return fecha_asignada;
	}

	public void setFecha_asignada(Date fecha_asignada) {
		this.fecha_asignada = fecha_asignada;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
