package com.proyecto.schoolroom.repositorios;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer>{

	public Grado findByCodigo(String codigo);
	
	@Query(value = "select seccion from grados where numero_grado = ?1", nativeQuery = true)
	public List<String> findBynum_grado(int num_grado);
	
}
