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


@Table(name = "GRADOS")
@Entity
public class Grado{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NUMERO_GRADO", nullable = false, length = 50)
	private String num_grado;
	
	@Column(name = "SECCION", nullable = false, length = 2)
	private String seccion;
	
	@Column(name = "CODIGO_GRADO", nullable = false, length = 30)
	private String codigo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InscripcionE> inscripcionE;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InscripcionM> inscripcionM;
	//Constructores
	
	public Grado() {}

	public Grado(int id, String num_grado, String seccion, String codigo) {
		this.id = id;
		this.num_grado = num_grado;
		this.seccion = seccion;
		this.codigo = codigo;
	}
	
	public Grado(String num_grado, String seccion, String codigo) {
		this.num_grado = num_grado;
		this.seccion = seccion;
		this.codigo = codigo;
	}
	
	//Metodos
	
	public void addInscripcion(InscripcionE i) {
		if (!inscripcionE.contains(i)) {
			inscripcionE.add(i);
			i.setGrado(this);
		}
	}
	
	public void deleteInscripcion(InscripcionE i) {
		if (inscripcionE.contains(i)) {
			inscripcionE.remove(i);
			i.setGrado(null);
		}	
	}
	
	public void addInscripcion(InscripcionM i) {
		if (!inscripcionM.contains(i)) {
			inscripcionM.add(i);
			i.setGrado(this);
		}
	}
	
	public void deleteInscripcion(InscripcionM i) {
		if (inscripcionM.contains(i)) {
			inscripcionM.remove(i);
			i.setGrado(null);
		}	
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum_grado() {
		return num_grado;
	}

	public void setNum_grado(String num_grado) {
		this.num_grado = num_grado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	
}
