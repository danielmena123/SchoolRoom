package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer>{

}
