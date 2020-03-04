package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.InscripcionD;

@Repository
public interface InscripcionDRepository extends JpaRepository<InscripcionD, Integer>{

}
