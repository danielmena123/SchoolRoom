package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tarea extends JpaRepository<Tarea, Integer>{

}
