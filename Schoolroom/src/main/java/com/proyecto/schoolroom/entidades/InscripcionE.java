package com.proyecto.schoolroom.entidades;

import java.util.Date;

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
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "INSCRIPCION_ENCARGADOS")
@Entity
public class InscripcionE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "FECHA_INSCRIPCION", nullable = false, length = 20)
	private Date fecha_inscripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENCARGADO")
	@JsonBackReference("encargado")
		private Encargado encargado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRADO")
	@JsonBackReference("grado")
		private Grado grado;
	
	//Constructores
	
	public InscripcionE() {}

	public InscripcionE(int id, Date fecha_inscripcion, Encargado encargado, Grado grado) {
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.encargado = encargado;
		this.grado = grado;
	}
	
	public InscripcionE(Date fecha_inscripcion, Encargado encargado, Grado grado) {
		this.fecha_inscripcion = fecha_inscripcion;
		this.encargado = encargado;
		this.grado = grado;
	}
	
	//Metodos
	
	@JsonProperty("encargado")
	private void addEncargado(Integer id) {
	    this.encargado = new Encargado();
	    encargado.setId(id);
	}
	
	@JsonProperty("grado")
	private void addGrado(Integer id) {
	    this.grado = new Grado();
	    grado.setId(id);
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	
}
