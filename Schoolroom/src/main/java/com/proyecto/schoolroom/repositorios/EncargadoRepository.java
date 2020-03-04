package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.Encargado;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Integer>{

}
