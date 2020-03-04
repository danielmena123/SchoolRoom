package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer>{

}
