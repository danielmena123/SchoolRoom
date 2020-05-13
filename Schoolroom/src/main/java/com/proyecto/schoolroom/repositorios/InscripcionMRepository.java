package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.InscripcionM;

@Repository
public interface InscripcionMRepository extends JpaRepository<InscripcionM, Integer>{

}
