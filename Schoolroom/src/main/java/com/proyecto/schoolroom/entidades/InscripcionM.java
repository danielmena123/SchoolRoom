package com.proyecto.schoolroom.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "INSCRIPCION_MATERIAS")
@Entity
public class InscripcionM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FECHA_INSCRIPCION", nullable = false, length = 20)
	private Date fecha_inscripcion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DOCENTE")
	@JsonBackReference("docente")
		private Docente docente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GRADO")
	@JsonBackReference("grado")
		private Grado grado;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MATERIA")
	@JsonBackReference("materia")
			private Materia materia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "inscripcion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Tarea> tarea;
		
	//Constructores
	
	public InscripcionM() {}

	public InscripcionM(int id, Date fecha_inscripcion, Docente docente, Grado grado, Materia materia) {
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.docente = docente;
		this.grado = grado;
		this.materia = materia;
	}
	
	public InscripcionM(Date fecha_inscripcion, Docente docente, Grado grado, Materia materia) {
		this.fecha_inscripcion = fecha_inscripcion;
		this.docente = docente;
		this.grado = grado;
		this.materia = materia;
	}
	
	//Metodos

	@JsonProperty("docente")
	private void addDocente(Integer id) {
	    this.docente = new Docente();
	    docente.setId(id);
	}
	
	@JsonProperty("grado")
	private void addGrado(Integer id) {
	    this.grado = new Grado();
	    grado.setId(id);
	}
	
	@JsonProperty("materia")
	private void addMateria(Integer id) {
	    this.materia = new Materia();
	    materia.setId(id);
	}
	
	public void addInscripcion(Tarea i) {
		if (!tarea.contains(i)) {
			tarea.add(i);
			i.setInscripcion(this);
		}
	}
	
	public void deleteInscripcion(Tarea i) {
		if (tarea.contains(i)) {
			tarea.remove(i);
			i.setInscripcion(null);
		}	
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
