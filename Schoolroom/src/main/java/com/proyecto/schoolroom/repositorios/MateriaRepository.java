package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{

}
