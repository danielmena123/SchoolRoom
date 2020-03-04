package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.InscripcionE;

@Repository
public interface InscripcionERepository extends JpaRepository<InscripcionE, Integer>{

}
