package com.proyecto.schoolroom.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "DOCENTES")
@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOMBRE_DOCENTE", nullable = false, length = 30 )
	private String nombres;
	
	@Column(name = "APELLIDO_DOCENTE", nullable = false, length = 30 )
	private String apellidos;
	
	@Column(name = "CORREO_ELECTRONICO_DOCENTE", nullable = false, length = 50)
	private String correo_electronico;
	
	@JsonIgnore
	@OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InscripcionM> inscripcion;
	
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
	
	//Metodos
	
	public void addInscripcion(InscripcionM i) {
		if (!inscripcion.contains(i)) {
			inscripcion.add(i);
			i.setDocente(this);
		}
	}
	
	public void deleteInscripcion(InscripcionM i) {
		if (inscripcion.contains(i)) {
			inscripcion.remove(i);
			i.setDocente(null);
		}
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
