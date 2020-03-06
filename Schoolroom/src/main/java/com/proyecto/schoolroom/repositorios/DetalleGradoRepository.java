package com.proyecto.schoolroom.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.schoolroom.entidades.DetalleGrado;

@Repository
public interface DetalleGradoRepository extends JpaRepository<DetalleGrado, Integer>{

}
