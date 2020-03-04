package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer>{

}
