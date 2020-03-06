package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Tarea;
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>{

}
