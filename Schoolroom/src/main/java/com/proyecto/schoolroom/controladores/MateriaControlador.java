package com.proyecto.schoolroom.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entidades.Materia;
import com.proyecto.schoolroom.repositorios.MateriaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/materias/")
public class MateriaControlador {
	
	@Autowired
	MateriaRepository repo;
	
	//Elegir Materia
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Materia> elegirmateria(@PathVariable int id){
		Materia m = repo.findById(id).get();
		if (m != null) {
			return ResponseEntity.ok(m);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Materias
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Materia> listamateria(){
		return repo.findAll();
	}
	
	//Nueva Materia
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Materia> crearmateria(@RequestBody Materia m) {
		if (m != null) {
			repo.save(m);
			return ResponseEntity.ok(m);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Editar Materia
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Materia> actualizarmateria(@PathVariable int id , @RequestBody Materia m){
		Materia n = repo.findById(id).get();
		if (n != null) {
			repo.save(m);
			return ResponseEntity.ok(m);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar Materia
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Materia> eliminarmateria(@PathVariable int id){
		Materia m = repo.findById(id).get();
		if (m != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(m);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
