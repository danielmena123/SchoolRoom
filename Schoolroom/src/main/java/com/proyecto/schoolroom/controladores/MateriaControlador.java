package com.proyecto.schoolroom.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Materia> elegirmateria(@PathVariable int id){
		Materia materia = repo.findById(id).get();
		if (materia != null) {
			return new ResponseEntity<>(materia, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Materia> listamateria(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Materia> crearmateria(@RequestBody Materia materia){
		repo.save(materia);
		return new ResponseEntity<>(materia, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Materia> actualizarmateria(@PathVariable int id , @RequestBody Materia update){
		Materia materia = repo.findById(id).get();
		if (materia != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Materia> eliminarmateria(@PathVariable int id){
		Materia materia = repo.findById(id).get();
		if (materia != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(materia, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
