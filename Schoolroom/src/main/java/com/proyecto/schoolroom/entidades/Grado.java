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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "NUMERO_GRADO", nullable = false, length = 20)
	private int num_grado;
	
	@Column(name = "SECCION_GRADO", nullable = false, length = 3)
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
	
	//HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + id;
		result = prime * result + ((inscripcionE == null) ? 0 : inscripcionE.hashCode());
		result = prime * result + ((inscripcionM == null) ? 0 : inscripcionM.hashCode());
		result = prime * result + num_grado;
		result = prime * result + ((seccion == null) ? 0 : seccion.hashCode());
		return result;
	}
	
	//Equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grado other = (Grado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		if (inscripcionE == null) {
			if (other.inscripcionE != null)
				return false;
		} else if (!inscripcionE.equals(other.inscripcionE))
			return false;
		if (inscripcionM == null) {
			if (other.inscripcionM != null)
				return false;
		} else if (!inscripcionM.equals(other.inscripcionM))
			return false;
		if (num_grado != other.num_grado)
			return false;
		if (seccion == null) {
			if (other.seccion != null)
				return false;
		} else if (!seccion.equals(other.seccion))
			return false;
		return true;
	}
	
	
}
