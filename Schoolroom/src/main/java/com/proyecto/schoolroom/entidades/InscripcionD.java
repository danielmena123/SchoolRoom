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

@Table
@Entity
public class InscripcionD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private Date fecha_inscripcion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iddocente")
	@JsonBackReference("docente")
		private Docente docente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idgrado")
	@JsonBackReference("grado")
		private Grado grado;
	
	//Constructores
	
	public InscripcionD() {}

	public InscripcionD(int id, Date fecha_inscripcion, Docente docente, Grado grado) {
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.docente = docente;
		this.grado = grado;
	}
	
	public InscripcionD(Date fecha_inscripcion, Docente docente, Grado grado) {
		this.fecha_inscripcion = fecha_inscripcion;
		this.docente = docente;
		this.grado = grado;
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

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	
}
